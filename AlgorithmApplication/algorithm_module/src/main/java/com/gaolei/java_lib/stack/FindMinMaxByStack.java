package com.gaolei.java_lib.stack;

import java.util.Stack;

public class FindMinMaxByStack<E extends Comparable<E>> {
    Stack<E> stack1 = new Stack<E>();
    Stack<E> stackMin = new Stack<E>();//存放求最小值的栈
    Stack<E> stackMax = new Stack<E>();//存放求最大值的栈

    public static void main(String[] args) {
        FindMinMaxByStack<Integer> demo08 = new FindMinMaxByStack();
        demo08.push(1);
        demo08.push(2);
        demo08.push(3);
        demo08.push(4);
        demo08.push(3);
        demo08.push(2);
        System.out.println("min:" + demo08.getMin());
        System.out.println("max:" + demo08.getMax());
        System.out.println("pop" + demo08.pop());
        System.out.println("max:" + demo08.getMax());
        System.out.println("min:" + demo08.getMin());
        demo08.push(5);
        System.out.println("pop:" + demo08.pop());

    }

    public void push(E e) {

        stack1.push(e);

        if (stackMin.isEmpty() || e.compareTo(stackMin.peek()) < 0) {
            //若最小栈为空push进stack时就同时把它push进stackMin;
            stackMin.push(e);
        }

        if (stackMax.isEmpty() || e.compareTo(stackMax.peek()) > 0) {
            stackMax.push(e);
        }
    }

    public E pop()//一定要记着，非空才能pop()
    {
        if (!stack1.isEmpty() && !stackMin.isEmpty() && !stackMax.isEmpty()) {
            E e = stack1.pop();
            if (e == stackMin.peek())
                stackMin.pop();
            if (e == stackMax.peek())
                stackMax.pop();
            return e;
        } else {
            System.out.println("栈已经为空了");
            return null;
        }

    }

    public E getMin() {
        E result = null;
        if (!stackMin.isEmpty()) result = stackMin.peek();
        return result;
    }

    public E getMax() {
        E result = null;
        if (!stackMax.isEmpty()) result = stackMax.peek();
        return result;
    }
//        public E getMed()
//        {
//            E[] ss=stack1.toArray(new E[stack1.size()]);//stack1.toArray()返回的是Object[],  栈----->数组;不能toArray后再强制转换，会报错
//            Arrays.sort(ss);
//            return ss[ss.length/2];
//        }

}