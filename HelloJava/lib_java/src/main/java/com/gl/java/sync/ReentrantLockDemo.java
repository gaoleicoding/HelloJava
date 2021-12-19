package com.gl.java.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
    private static int count = 0;
    private final int privilege;
    private final static int THREADNUM = 3;

    public ReentrantLockDemo(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public void run() {
        lock.lock();
        try {

            while (count <= 75) {
                System.out.println(Thread.currentThread().getName() + " count: " + count);
                if (count % THREADNUM != privilege) {
                    condition.await();
                } else {
                    System.out.println("Thread " + Thread.currentThread().getName() + " print :" + count++);
                    condition.signal();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new ReentrantLockDemo(0)).start();
        new Thread(new ReentrantLockDemo(1)).start();
        new Thread(new ReentrantLockDemo(2)).start();
    }
}

/*
        ReentrantLock的Condition使用问题，
        跑了一下，能够正常运行，输出结果：

        Thread Thread-0 print :0

        Thread Thread-1 print :1

        Thread Thread-2 print :2

        ……

        但是多运行几次就出现问题了：出现一个很奇怪的现象，整个进程会卡死，什么！！卡死~

        问题就出在 condition.wait();看下面一个运行日志：

        Thread-2 count: 0
        Thread-1 count: 0
        Thread-0 count: 0
        Thread Thread-0 print :0
        Thread-0 count: 1
        Thread-2 count: 1

        3个线程运行的流程大致如下：

        线程2进入 -> 线程2wait –> 线程1进入 –> 线程1等待 –> 线程0进入

        -> 线程0运行print –> 线程0 signal() ->唤醒线程2-> 线程2 wait ->线程0wait 这个时候3个线程都处于wait状态。

        问题原因：signal()只会从等待队列里唤醒一个线程，如果这个线程不能继续signal就会出现问题。

        解决的办法：

        condition.wait() 改为condition.waitNanos(200); 提供线程等待一定时间退出；
        condition.signal()改为condition.signalAll();唤醒所有线程

        */
