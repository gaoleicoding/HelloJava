package com.gl.java.sync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {

        AtomicInteger a = new AtomicInteger(0);
        for (int i = 1; i < 5; i++) {
            a.getAndIncrement(); // a 自增，相当于 a ++
        }
        //获取当前a的值
        System.out.println("AtomicInteger a从0自增4次结果为："+ a.get());

        System.out.println("AtomicInteger 当前a为："+ a.getAndDecrement() + "，并自减一次"); //a --

        //获取当前a的值，并更新a为8
        System.out.println("AtomicInteger a当前值为："+a.getAndSet(8)+"，并更新a为8");

        //获取当前a的值，并将a加6
        System.out.println("AtomicInteger a当前值为："+a.getAndAdd(6)+"，并将a加6");

        a.compareAndSet(12,9); //如果a=12，就把a更新为9，否则不进行操作
        System.out.println("AtomicInteger a当前值为："+a.get());

        a.compareAndSet(14,9); //如果a=14，就把a更新为9，否则不进行操作
        System.out.println("AtomicInteger a当前值为："+a.get());

    }
}

