package com.gaolei.java_lib.myqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueTest3 {
    public static void main(String[] args) {

        System.out.println("3.两个堆栈实现一个队列：");
        ArrayQueue queue = new ArrayQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println("size：" + queue.size);

    }

    //两个堆栈实现一个队列
    static class StackQueue {

        Stack<Integer> stackA = new Stack<Integer>();
        Stack<Integer> stackB = new Stack<Integer>();
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

    //使用集合定义一个队列
    class ListQueue {

        List<Integer> list = new ArrayList<Integer>();
        int index = 0;  //下标

        //入队
        public void push(int n) {
            list.add(n);
            index++;
        }

        //出队
        public int pop() {
            if (!list.isEmpty()) {
                index--;
                return list.remove(0);
            }
            return -1;
        }

        public int getSize() {
            return index;
        }
    }

    //使用集合定义一个队列
    static class ArrayQueue {
        int capacity = 10;
        int array[] = new int[capacity];
        int size = 0,head=0,tail=0;  //下标

        //入队
        public void push(int n) {
            array[tail++]=n;
            size++;
        }

        //出队
        public int pop() {
            if (size>0) {
                int value= array[head];
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
}
