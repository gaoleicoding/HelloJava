package com.gaolei.java_lib.linkedlist;

/**
 * Description：两种方式实现单链表的反转(递归、普通)
 */
public class LinkedListReverse {

    public static void main(String[] args) {
        //带有头结点
        LinkedNode head = getLinkedNode();
        //打印反转前的链表
        LinkedNode h = head;
        while (h != null) {
            System.out.print(h.getVal() + " ");

            h = h.getNext();
        }
        System.out.println("\n*******************");
        //调用反转方法
        head = reverse2(head);
        System.out.println("\n*******************");
        //打印反转后的结果
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
    }

    private static LinkedNode getLinkedNode() {
        LinkedNode head = new LinkedNode(0);
        LinkedNode tmp = null;  // 保存临时变量
        LinkedNode cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = 1; i < 10; i++) {
            tmp = new LinkedNode(i);
            if (1 == i) {
                head.setNext(tmp);
            } else {
                cur.setNext(tmp);
            }
            cur = tmp;
        }
        return head;
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    //最终传递一个指向最后一个节点的变量
    public static LinkedNode reverse1(LinkedNode head) {
        //当为空或者本节点为末尾节点的时候
        if (head == null || head.getNext() == null)
            return head;
        LinkedNode reversedHead = reverse1(head.getNext());
        //获取先前的下一个节点，让该节点指向自身
        head.getNext().setNext(head);
        //破坏以前自己指向下一个节点
        head.setNext(null);
        //层层传递给最上面的
        return reversedHead;
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static LinkedNode reverse2(LinkedNode head) {
        if (null == head) {
            return head;
        }
        LinkedNode pre = head;
        LinkedNode cur = head.getNext();
        LinkedNode next;

        while (cur != null) {
            System.out.println("pre.getRecord() " + pre.getVal());
            //断之前先找到原始的下一个节点
            next = cur.getNext();
            //逆序连接
            cur.setNext(pre);
            //两个节点同时滑动
            pre = cur;
            cur = next;

        }
        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        head.setNext(null);
        head = pre;
        return head;
    }

} 