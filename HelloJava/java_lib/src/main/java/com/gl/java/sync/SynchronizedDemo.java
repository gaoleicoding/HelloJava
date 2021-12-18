package com.gl.java.sync;

public class SynchronizedDemo {

    public static void main(String[] args) {
        syncMethod1();
        SynchronizedDemo test = new SynchronizedDemo();
        test.syncMethod2();
        test.syncMethod3();
        test.syncMethod4();
    }

    public static void nonsyncMethod() {
        System.out.println("nonsyncMethod");
    }

    public synchronized static void syncMethod1() {
        System.out.println("syncMethod1");
    }

    public synchronized void syncMethod2() {
        System.out.println("syncMethod2");
    }

    public synchronized void syncMethod3() {
        synchronized (SynchronizedDemo.this) {
            System.out.println("syncMethod3");
        }
    }

    public synchronized void syncMethod4() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("syncMethod4");
        }
    }

}