package com.gl.java.classload;

public class JVMClass2 {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getSingleton();
        Singleton2 s2 = Singleton2.getSingleton();
        System.out.println("s1:counter1 = "+ s1.counter1);
        System.out.println("s1:counter2 = "+s1.counter2);
        System.out.println("s2:counter1 = "+ s2.counter1);
        System.out.println("s2:counter2 = "+s2.counter2);
    }
}
class Singleton1{
    private static Singleton1 singleton = new Singleton1();
    public static int counter1;
    public static int counter2 = 0;
    public Singleton1(){
        counter1++;
        counter2++;
    }

    public static Singleton1 getSingleton(){
        return singleton;
    }
}
class Singleton2{
    public static int counter1;
    public static int counter2 = 0;
    private static Singleton2 singleton = new Singleton2();
    public Singleton2(){
        counter1++;
        counter2++;
    }

    public static Singleton2 getSingleton(){
        return singleton;
    }
}