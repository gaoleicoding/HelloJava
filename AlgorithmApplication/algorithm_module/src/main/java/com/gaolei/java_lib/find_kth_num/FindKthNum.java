package com.gaolei.java_lib.find_kth_num;

import com.gaolei.java_lib.linkedlist.LinkedNode;

/**
 * Description：找出一个单链表中倒数第K个节点
 */
public class FindKthNum {
    public static void main(String[] args) {
        LinkedNode head = makeList1();
        LinkedNode k = findK(head, 1);
        System.out.println("k---------------" + k.val);
    }

    public static LinkedNode findK(LinkedNode head, int k) {
        if (k < 0) return null;
        LinkedNode p1 = head;
        LinkedNode p2 = head;
        //先将P2向前移动k个结点
        for (int i = 0; i < k; i++) {
            if (null == p2) return null;
            else p2 = p2.next;
        }
        if (null == p2) return null;

        //接着以同样的速度移动p1和p2，当p2抵达链表末尾时，p1指向第K个结点
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static LinkedNode makeList1() {
        //带有头结点
        LinkedNode head = new LinkedNode(1);
        LinkedNode tmp;  // 保存临时变量
        LinkedNode cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = 2; i < 10; i++) {
            tmp = new LinkedNode(i);
            if (2 == i) {
                head.next = tmp;
            } else {
                cur.next = tmp;
            }
            cur = tmp;
        }
        //打印链表
        return head;

    }
}
