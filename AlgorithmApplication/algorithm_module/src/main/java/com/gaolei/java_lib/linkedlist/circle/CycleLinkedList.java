package com.gaolei.java_lib.linkedlist.circle;

/**
 * Description: 判断单向链表是否有环
 */
public class CycleLinkedList {
    /**
     * 判断是否有环
     *
     * @param head 链表头节点
     * @return
     */

    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  //一旦两环相遇 则说明链表有环
                return true;
            }
        }
        return false;
    }

    /**
     * 如果链表有环，如何求出环的长度
     */

    public static int getCycleLength(Node head) {
        if (head == null) {
            return 0;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                //若带环，则fast与slow两次相遇之间，slow走过的节点数即为环的长度
                while (fast != slow) {
                    len++;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return len;

            }
        }
        return 0;

    }

    /**
     * 如果链表有环，求出入环节点
     */

    public static int getCycleNode(Node head) {
        if (head == null) {
            return 0;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //第一轮相遇
            if (fast == slow) {
                fast = head;
                //构建第二轮相遇  fast在第一轮相遇后返回起点开始走 slow不动从相遇点走
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow.data;

            }
        }
        return 0;

    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println("isCycle: "+isCycle(node1));
        System.out.println("getCycleLength: "+getCycleLength(node1));
        System.out.println("getCycleNode: "+ getCycleNode(node1));
    }
}

