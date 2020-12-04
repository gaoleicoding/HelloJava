package com.gaolei.java_lib.linkedlist_reverse;

// 定义一个单链表
class Node {
    //变量  
    private int val;
    //指向下一个对象  
    private Node nextNode;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}  