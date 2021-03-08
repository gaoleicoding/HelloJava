package com.gaolei.java_lib.linkedlist.num_add;

import com.gaolei.java_lib.linkedlist.Node;

/**
 * Description：两个链表的数子相加
 */
public class LinkedListNumAdd {


    public static void main(String[] args) {

        Node header = addTwoList(makeList(1, 2, 10), makeList(2, 3, 7));
        StringBuilder builder = new StringBuilder();
        Node tmp = header;
        while (tmp != null) {
            builder.append(tmp.val);
            tmp = tmp.next;
        }
        System.out.println(builder.toString());
    }

    public static Node makeList(int head, int start, int end) {
        //带有头结点
        Node header = new Node(head);
        Node tmp;  // 保存临时变量
        Node cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = start; i < end; i++) {
            tmp = new Node(i);
            if (2 == i) {
                header.next = tmp;
            } else {
                cur.next = tmp;
            }
            cur = tmp;
        }
        return header;

    }


    public static Node addTwoList(Node l1, Node l2) {

        Node header = new Node(0);
        Node p = l1, q = l2, tmp = header;
        int curry = 0;

        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + curry;
            curry = sum / 10;
            tmp.next = new Node(sum % 10);
            tmp = tmp.next;

            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;

        }

        if (curry > 0) {
            tmp.next = new Node(curry);
        }
        return header.next;
    }
}

