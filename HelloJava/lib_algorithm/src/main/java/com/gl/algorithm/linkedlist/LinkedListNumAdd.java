package com.gl.algorithm.linkedlist;


/**
 * Description：两个链表的数子相加
 */
public class LinkedListNumAdd {


    public static void main(String[] args) {

        LinkedNode header = addTwoList(makeList(1, 2, 10), makeList(2, 3, 7));
        StringBuilder builder = new StringBuilder();
        LinkedNode tmp = header;
        while (tmp != null) {
            builder.append(tmp.val);
            tmp = tmp.next;
        }
        System.out.println(builder.toString());
    }

    public static LinkedNode makeList(int head, int start, int end) {
        //带有头结点
        LinkedNode header = new LinkedNode(head);
        LinkedNode tmp;  // 保存临时变量
        LinkedNode cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = start; i < end; i++) {
            tmp = new LinkedNode(i);
            if (2 == i) {
                header.next = tmp;
            } else {
                cur.next = tmp;
            }
            cur = tmp;
        }
        return header;

    }


    public static LinkedNode addTwoList(LinkedNode l1, LinkedNode l2) {

        LinkedNode header = new LinkedNode(0);
        LinkedNode p = l1, q = l2, tmp = header;
        int curry = 0;

        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + curry;
            curry = sum / 10;
            tmp.next = new LinkedNode(sum % 10);
            tmp = tmp.next;

            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;

        }

        if (curry > 0) {
            tmp.next = new LinkedNode(curry);
        }
        return header.next;
    }
}

