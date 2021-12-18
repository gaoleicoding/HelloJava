package com.gl.java.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueueDemo {
    public static void main(String[] args) {
        final BoundedBuffer boundedBuffer = new BoundedBuffer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("putting..");
                        boundedBuffer.put(Integer.valueOf(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Object val = boundedBuffer.take();
                        System.out.println(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t1.start();
        t2.start();
    }

    /**
     * BoundedBuffer 是一个定长100的集合，当集合中没有元素时，take方法需要等待，直到有元素时才返回元素
     * 当其中的元素数达到最大值时，要等待直到元素被take之后才执行put的操作
     *
     * @author yukaizhao
     */
    static class BoundedBuffer {
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[100];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            System.out.println("put wait lock");
            lock.lock();
            System.out.println("put get lock");
            try {
                while (count == items.length) {
                    System.out.println("buffer full, please wait");
                    notFull.await();
                }

                items[putptr] = x;
                if (++putptr == items.length)
                    putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            System.out.println("take wait lock");
            lock.lock();
            System.out.println("take get lock");
            try {
                while (count == 0) {
                    System.out.println("no elements, please wait");
                    notEmpty.await();
                }
                Object x = items[takeptr];
                if (++takeptr == items.length)
                    takeptr = 0;
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }
}

/*
这是一个处于多线程工作环境下的缓存区，缓存区提供了两个方法，put和take，put是存数据，take是取数据，内部有个缓存队列，
这个缓存区类实现的功能：有多个线程往里面存数据和从里面取数据，其缓存队列(先进先出后进后出)能缓存的最大数值是100，多个线程间是互斥的，
当缓存队列中存储的值达到100时，将写线程阻塞，并唤醒读线程，当缓存队列中存储的值为0时，将读线程阻塞，并唤醒写线程，
这也是ArrayBlockingQueue的内部实现。

        下面分析一下代码的执行过程：

        1. 一个写线程执行，调用put方法；

        2. 判断count是否为100，显然没有100；

        3. 继续执行，存入值；

        4. 判断当前写入的索引位置++后，是否和100相等，相等将写入索引值变为0，并将count+1；

        5. 仅唤醒读线程阻塞队列中的一个；

        6. 一个读线程执行，调用take方法；

        7. ……

        8. 仅唤醒写线程阻塞队列中的一个。

        这就是多个Condition的强大之处，假设缓存队列中已经存满，那么阻塞的肯定是写线程，唤醒的肯定是读线程，相反，阻塞的肯定是读线程，唤醒的肯定是写线程，那么假设只有一个Condition会有什么效果呢，缓存队列中已经存满，这个Lock不知道唤醒的是读线程还是写线程了，如果唤醒的是读线程，皆大欢喜，如果唤醒的是写线程，那么线程刚被唤醒，又被阻塞了，这时又去唤醒，这样就浪费了很多时间。

*/
