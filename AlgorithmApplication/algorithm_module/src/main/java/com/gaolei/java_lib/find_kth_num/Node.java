package com.gaolei.java_lib.find_kth_num;

// 定义一个单链表
public class Node {

    public Node(int val) {
        this.val = val;
    }

    //变量
    public int val;
    //指向下一个对象  
    public Node next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
    
