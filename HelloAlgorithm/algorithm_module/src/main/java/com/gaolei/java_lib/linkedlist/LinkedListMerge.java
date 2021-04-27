package com.gaolei.java_lib.linkedlist;

import com.gaolei.java_lib.linkedlist.LinkedNode;

/**
 * Description：两个有序数组合并为一个有序数组
 */
public class LinkedListMerge {

    public LinkedListMerge() {

    }


    //将两个有序链表合并为一个新的有序链表（升序为例）
    public static LinkedNode conflateList(LinkedNode head1, LinkedNode head2) {
        //先进行判空
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //设置两个引用分别指向两个链表
        LinkedNode cur1 = head1;
        LinkedNode cur2 = head2;
        //设置将要合成的链表的头和尾
        LinkedNode newHead = null;
        LinkedNode newTail = null;
        //两个链表任何一个为空循环就终止
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (newHead == null) {
                    //当新链表为空时
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                }
                //新链表不为空时
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                if (newHead == null) {
                    newHead = cur2;
                    newTail = cur2;
                    cur2 = cur2.next;
                }
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        //循环终止之后 把还剩有结点的链表并到新链表尾部即可
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedNode head1 = null, tail1 = null;
        LinkedNode head2 = null, tail2 = null;
        for (int i = 1; i <= 10; i++) {
            LinkedNode node = new LinkedNode(i);
            if (head1 == null) {
                tail1 = node;
                head1 = tail1;
            } else {
                tail1.next = node;
                tail1 = tail1.next;
            }
        }
        for (int i = 8; i <= 13; i++) {
            LinkedNode node = new LinkedNode(i);
            if (head2 == null) {
                head2 = node;
                tail2 = node;
            } else {
                tail2.next = node;
                tail2 = tail2.next;
            }
        }

        LinkedNode node = conflateList(head1, head2);
        System.out.print(node.val + "、");
        LinkedNode tempNode = node;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            System.out.print(tempNode.val + "、");
        }
    }
}