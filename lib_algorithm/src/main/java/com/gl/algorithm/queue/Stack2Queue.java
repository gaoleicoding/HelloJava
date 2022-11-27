package com.gl.algorithm.queue;

import java.util.Stack;

class Stack2Queue<E> {
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public void offer(E val) {   //入队
        s1.push(val);
    }

    // 取出队列对头
    public E poll() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // 查看对列头
    public E peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() { //判断队是否为空
        return s2.empty();
    }
}