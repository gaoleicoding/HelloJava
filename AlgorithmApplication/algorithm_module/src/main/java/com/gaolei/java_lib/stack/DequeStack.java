package com.gaolei.java_lib.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description：自定义实现stack
 */
public class DequeStack<E> {

    // ArrayDeque是java中对双端队列的线性实现，当用作栈时，
    // 性能优于Stack，当用于队列时，性能优于LinkedList，不能存储null
    // 容器
    private Deque<E> container = new ArrayDeque<E>();
    //容量
    private int cap;

    public DequeStack(int cap) {
        super();
        this.cap = cap;
    }

    //压栈
    public boolean push(E e) {
        if (this.container.size() + 1 > this.cap) {
            return false;
        }
        return this.container.offerLast(e);

    }

    //弹栈
    public E pop() {
        return this.container.pollLast();
    }

    //出栈
    public E peak() {
        return this.container.peekLast();
    }

    public int size() {
        return this.container.size();
    }

    public static void main(String[] args) {
        DequeStack<String> stack = new DequeStack<String>(10);
        stack.push("a");
        stack.push("b");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
