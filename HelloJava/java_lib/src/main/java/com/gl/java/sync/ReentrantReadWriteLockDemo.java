package com.gl.java.sync;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 *  是一种基于lock的读写锁，在使用ReentrantLock时，它保证当前只有一个线程获取锁，
 * 但是有时候我们实际应用中会出现读多写少的场景，读于读之间都是读取同样的数据，
 *  如果使用ReentrantLock反而效率会低下，使用ReentrantReadWriteLock会很高效，
 *  它可以实现多个读锁同时进行，但是读与写和写于写互斥，只能有一个写锁线程在进行。
 */

public class ReentrantReadWriteLockDemo {
    static class MyDemo {
        // 实例化读写锁 默认非公平
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        // 模拟共享资源
        private int number;

        public void put(int number) {
            // 写锁加锁
            lock.writeLock().lock();
            try {
                Thread.sleep(500);
                this.number = number;
                System.out.println(Thread.currentThread().getName() + ":写入了" + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 写锁释放锁
                lock.writeLock().unlock();
            }
        }

        public int get() {
            // 读写 加锁
            lock.readLock().lock();
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":读取了" + number);
                return number;
            } finally {
                // 读锁解锁
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        // 三个写线程
        for (int i = 0; i < 3; i++) {
            new Thread(() -> myDemo.put(new Random().nextInt(100)), "写锁" + i).start();
        }
        // 十个读线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> myDemo.get(), "读锁" + i).start();
        }
    }
}
/*
        写锁2:写入了96
        读锁0:读取了96
        写锁1:写入了27
        读锁4:读取了27
        读锁6:读取了27
        读锁5:读取了27
        读锁3:读取了27
        读锁7:读取了27
        读锁1:读取了27
        读锁2:读取了27
        写锁0:写入了66
        读锁9:读取了66
        读锁8:读取了66
*/
