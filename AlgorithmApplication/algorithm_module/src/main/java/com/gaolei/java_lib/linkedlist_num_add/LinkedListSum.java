package com.gaolei.java_lib.linkedlist_num_add;



public class LinkedListSum {


    public static void main(String[] args) {
        Node node=addTwoList(makeList1(),makeList2());


    }

    public static Node makeList1(){
        //带有头结点
        Node head = new Node(1);
        Node tmp ;  // 保存临时变量
        Node cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = 2; i < 10; i++) {
            tmp = new Node(i);
            if (2 == i) {
                head.next=tmp;
            } else {
                cur.next=tmp;
            }
            cur = tmp;
        }
        //打印链表
       printList(head);
        return head;

    }
    public static Node makeList2(){
        //带有头结点
        Node head = new Node(1);
        Node tmp ;  // 保存临时变量
        Node cur = null;  // 始终指向末尾节点
        //构造一个长度为10的链表，保存头节点对象head
        //利用尾插入法
        for (int i = 2; i < 5; i++) {
            tmp = new Node(i);
            if (2 == i) {
                head.next=tmp;
            } else {
                cur.next=tmp;
            }
            cur = tmp;
        }
        //打印链表

        printList(head);
        return head;
    }
        /**
         * 002-Add Two Numbers (单链表表示的两个数相加)
         * @param l1 第一个数
         * @param l2 第二个数
         * @return 结果
         */
        public static Node addTwoList(Node l1, Node l2) {


            Node head1=reverseLinkedList(l1);
            System.out.println( " \n----------------l1.val："+l1.val+"\n");
            printList(head1);
            Node head2=reverseLinkedList(l2);
            System.out.println( " \n----------------l2.val："+l2.val+"\n");
            printList(head2);

            Node addHead=addTwoNumbers(head1,head2);
            Node finalHead=reverseLinkedList(addHead);
            printList(finalHead);
            return finalHead;
        }


        public static Node reverseLinkedList(Node head){

            Node pre=head;
            Node cur=head.next;
            Node next;
            while (cur!=null){
                next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            head.next=null;
            return pre;
        }


    public static Node addTwoNumbers(Node l1, Node l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node p1 = l1;
        Node p2 = l2;
        Node root = new Node(0); // 头结点
        Node r = root;
        root.next = l1;

        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10; // 本位的结果
            carry = sum / 10; // 本次进位

            r.next = p1;
            r = p1; // 指向最后一个相加的结点
            p1 = p1.next;
            p2 = p2.next;

        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }

        // 最后一次相加还有进位
        if (carry == 1) {
            // 開始时r.next是第一个要相加的结点
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
                r = r.next;
            }

            // 都加完了还有进位。就要创建一个新的结点
            if (carry == 1) {
                r.next = new Node(1);
            }
        }

        return root.next;
    }


    public static  void printList(Node node){
        System.out.println( "\n");
        Node tmp=node;
        while (tmp!=null) {

            System.out.println(tmp.val);
            tmp=tmp.next;
        }
        System.out.println( "\n");
    }
}

