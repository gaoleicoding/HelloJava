package com.gaolei.java_lib.queue;

import java.util.Stack;
 
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
 
    public void push(int node) {
        stack1.push(node);
    }
 
    public int pop() {
        if(stack2.size()<=0){
            while(stack1.size()>0){
                /*int data = stack1.peek();//查看栈顶元素，但不移除它
                stack1.pop();//弹出栈顶元素
                stack2.push(data);//压入
                 */                             
                stack2.push(stack1.pop());
            }
        }
 
        if(stack2.isEmpty()){
            try {
                throw new Exception("queue is empty.");
            } catch (Exception e) {
            }
        }
        /**
         * int head = stack2.peek();
         * stack2.pop();
         */
        int head = stack2.pop();
        return head;
 
    }
}