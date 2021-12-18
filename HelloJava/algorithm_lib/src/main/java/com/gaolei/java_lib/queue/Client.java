package com.gaolei.java_lib.queue;

public class Client {
    public static void main(String[] args) {

        Stack2Queue<Integer> queue = new Stack2Queue<>();
        for (int i = 1; i < 7; i++) {
            queue.offer(i);
        }
        System.out.println();
        System.out.println("出队：");
        System.out.print(queue.poll() + " ");
    }

}
