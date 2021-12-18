package com.gaolei.java_lib.stack;

import java.util.ArrayDeque;
import java.util.Queue;

class Queue2Stack<E> {
    private Queue<E> que1; // 存放栈的元素
    private Queue<E> que2; // 做一个辅助操作
    private int size;

    public Queue2Stack() {
        this.que1 = new ArrayDeque<>();
        this.que2 = new ArrayDeque<>();
    }

    public Queue2Stack(int size) {
        this.size = size;
        this.que1 = new ArrayDeque<>(size);
        this.que2 = new ArrayDeque<>(size);
    }

    public void push(E val) {
        this.que1.offer(val);
    }

    public E pop() {
        // 从que1出队，把最后一个出队的元素返回
        E data = null;
        /**
         * 把que1里面的所有元素出队，放入que2里面，
         * 然后把que1最后一个出队的元素直接返回，不用放入que2
         */
        while (!this.que1.isEmpty()) {
            data = this.que1.poll();
            if (this.que1.isEmpty()) {
                break;
            }
            this.que2.offer(data);
        }

        // 获取该出栈的元素以后，再把que2的元素再放入que1里面
        while (!this.que2.isEmpty()) {
            this.que1.offer(this.que2.poll());
        }

        return data;
    }

    public E top() {
        // 从que1出队，把最后一个出队的元素返回
        E data = null;

        while (!this.que1.isEmpty()) {
            data = this.que1.poll();
            this.que2.offer(data);
        }

        // 获取该出栈的元素以后，再把que2的元素再放入que1里面
        while (!this.que2.isEmpty()) {
            this.que1.offer(this.que2.poll());
        }

        return data;
    }

    public boolean full() {
        return this.que1.size() == size;
    }

    public boolean empty() {
        return this.que1.isEmpty();
    }
}