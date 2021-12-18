package com.gl.java.sync;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLockDemo
 * 它是Jdk在1.8提供的一种读写锁，相比较ReentrantReadWriteLock性能更好，
 * 因为ReentrantReadWriteLock在读写之间是互斥的，使用的是一种悲观策略，在读线程特别多的情况下，
 * 会造成写线程处于饥饿状态，虽然可以在初始化的时候设置为true指定为公平，但是吞吐量又下去了，
 * 而StampedLock是提供了一种乐观策略，更好的实现读写分离，并且吞吐量不会下降。
 */

class StampedLockPoint {
    // 内部定义表示坐标点
    private double x, y;
    //定义了StampedLock锁,
    private final StampedLock s1 = new StampedLock();

    // 写锁
    public void move(double deltaX, double deltaY) {
        // 获得写锁 凭据
        long stamp = s1.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            s1.unlockWrite(stamp);
        }
    }

    // 乐观锁读
    public double distanceFormOrigin() {
        //尝试乐观读 返回stamp凭证
        long stamp = s1.tryOptimisticRead();
        //读取x和y的值,这时候我们并不确定x和y是否是一致的 需要下一步再次判断
        double currentX = x, currentY = y;
        /**
         * 判断stamp在读过程发生期间被修改过，如果没有被修改，则这次读取有效，直接return
         * 如果stamp被修改过，则有可能其他线程改写了数据，会出现脏读，可以使用死循环使用乐观锁读，直到成功
         * 也可以使用锁的级别，将乐观锁变为悲观锁
         */
        if (!s1.validate(stamp))
            // 使用悲观锁读 如果有写线程那么该线程会挂起
            stamp = s1.readLock();
        try {
            currentX = x;
            currentY = y;
        } finally {
            // 释放读锁
            s1.unlockRead(stamp);
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    // 读锁转为写锁
    public void moveIfAtOrigin(double newX, double newY) {
        // 读锁加锁 可以使用乐观读锁替代
        long stamp = s1.readLock();
        try {
            // 如果当前是原点 则修改
            while (x == 0.0 && y == 0.0) {
                // 尝试升级为写锁
                long ws = s1.tryConvertToWriteLock(stamp);
                // 升级成功 更新stamp凭据 设置坐标值 退出循环
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    // 升级失败 释放读锁，重新获取写锁，循环重试
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }
            }
        } finally {
            // 释放锁
            s1.unlock(stamp);
        }
    }
}
