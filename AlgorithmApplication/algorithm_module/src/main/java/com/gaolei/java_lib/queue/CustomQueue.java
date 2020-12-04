package com.gaolei.java_lib.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Description：自定义实现queue
 */
public class CustomQueue {
    public static void main(String[] args) {

        System.out.println("3.两个堆栈实现一个队列：");
        ArrayDequeQueue queue = new ArrayDequeQueue(88);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println("size：" + queue.getSize());

    }

    //两个堆栈实现一个队列
    static class StackQueue {

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        int size = 0;

        //入队
        public void push(int n) {
            stackA.push(n);
            size++;
        }

        //出队
        public int pop() {
            if (stackB.isEmpty()) {
                while (stackA.size() > 0) {
                    stackB.push(stackA.pop());
                }
            }
            size--;
            return stackB.pop();
        }

        public int getSize() {
            return size;
        }
    }

    //使用List方式定义一个队列
    class ListQueue {

        List<Integer> list = new ArrayList<Integer>();
        int size = 0;  //下标

        //入队
        public void push(int n) {
            list.add(n);
            size++;
        }

        //出队
        public int pop() {
            if (!list.isEmpty()) {
                size--;
                return list.remove(0);
            }
            return -1;
        }

        public int getSize() {
            return size;
        }
    }

    //使用Array方式定义一个队列
    static class ArrayQueue {
        int capacity = 10;
        int array[] = new int[capacity];
        int size = 0, head = 0, tail = 0;  //下标

        //入队
        public void push(int n) {
            array[tail++] = n;
            size++;
        }

        //出队
        public int pop() {
            if (size > 0) {
                int value = array[head];
                size--;
                head++;
                return value;
            }
            return -1;
        }

        public int getSize() {
            return size;
        }
    }

    //ArrayDeque是java中对双端队列的线性实现，当用作栈时，
    // 性能优于Stack，当用于队列时，性能优于LinkedList，不能存储null
    static class ArrayDequeQueue<E> {
        private Deque<E> container = new ArrayDeque<E>();
        //容量
        private int cap;

        public ArrayDequeQueue(int cap) {
            super();
            this.cap = cap;
        }

        //压站
        public boolean push(E e) {
            if (this.container.size() + 1 > this.cap) {
                return false;
            }
            return this.container.offerLast(e);

        }

        //弹站
        public E pop() {
            return this.container.pollFirst();
        }

        //出战
        public E peak() {
            return this.container.peekLast();
        }

        public int getSize() {
            return this.container.size();
        }
    }
}
