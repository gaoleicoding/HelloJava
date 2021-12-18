package com.gaolei.java_lib.linkedlist;

// 定义一个单链表
public class LinkedNode {

    public LinkedNode(int val) {
        this.val = val;
    }

    //变量
    public int val;
    //指向下一个对象  
    public LinkedNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
    
