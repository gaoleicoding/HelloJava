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

        ArrayToQueue arrayToQueue = new ArrayToQueue(16);
        arrayToQueue.push(15);
        arrayToQueue.push(1);
        arrayToQueue.push(13);
        arrayToQueue.push(8);
        arrayToQueue.push(3);
        arrayToQueue.push(19);

        while (arrayToQueue.getSize() > 0) {
            System.out.println("Queue.pop：" + arrayToQueue.pop());
        }

    }

    //两个堆栈实现一个队列
    static class StackToQueue {

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
    class ListToQueue {

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
    static class ArrayToQueue {
        int capacity = 10;
        int array[];
        int size = 0, head = 0, tail = 0;  //下标

        public ArrayToQueue(int capacity) {
            array = new int[capacity];
        }

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

}
