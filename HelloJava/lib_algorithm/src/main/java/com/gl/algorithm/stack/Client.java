package com.gl.algorithm.stack;

public class Client {
    public static void main(String[] args) {

        Queue2Stack<Integer> seqStack = new Queue2Stack<>();
        for (int i = 0; i < 5; i++) {
            seqStack.push(i);
        }
        System.out.println("出栈：");
        while (!seqStack.empty()) {
            System.out.print(seqStack.pop() + " ");
        }
    }


}
