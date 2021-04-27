package com.gaolei.java_lib.queue;

import java.util.Arrays;

/**
 * 队列
 */
public class Array2Queue {

    /**
     * 队列管道，当管道中存放的数据大于队列的长度时将不会再offer数据，直至从队列中poll数据后
     */
    private Object[] queue;
    //队列的头部，获取数据时总是从头部获取
    private int head;
    //队列尾部，push数据时总是从尾部添加
    private int tail;
    //数组中能存放数据的最大容量
    private final static int MAX_CAPACITY = 1 << 30;
    //数组长度
    private int capacity;
    //最大下标
    private int maxIndex;

    public Array2Queue(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY)
            throw new OutOfMemoryError("initialCapacity too large");
        if (initialCapacity <= 0)
            throw new IndexOutOfBoundsException("initialCapacity must be more than zero");
        queue = new Object[initialCapacity];
        capacity = initialCapacity;
        maxIndex = initialCapacity - 1;
    }

    public Array2Queue() {
        queue = new Object[16];
        capacity = 16;
        head = tail = -1;
        maxIndex = 15;
    }

    /**
     * 往队列尾部添加数据
     *
     * @param object 数据
     */
    public void offer(Object object) {
        if (queue.length > capacity) {
            System.out.println("queue's size more than or equal to array's capacity");
            return;
        }
        queue[queue.length] = object;
    }

    /**
     * 从队列头部拉出数据
     *
     * @return 返回队列的第一个数据
     */
    public Object poll() {
        if (queue.length <= 0) {
            System.out.println("the queue is null");
            return null;
        }
        if (++head > maxIndex) {
            head = 0;
        }
        Object old = queue[head];
        queue[head] = null;
        return old;
    }

    /**
     * 查看第一个数据
     *
     * @return
     */
    public Object peek() {
        return queue[head];
    }

    /**
     * 队列中存储的数据量
     *
     * @return
     */
    public int size() {
        return queue.length;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return queue.length == 0;
    }

    /**
     * 清空队列
     */
    public void clear() {
        Arrays.fill(queue, null);
        tail = head = 0;
    }


}