package com.maginazt;

/**
 * Created by zhaotao on 16/7/31.
 */
public class Number82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode firstNode = new ListNode(0);
        ListNode tail = firstNode;
        ListNode p = head;
        int occurs = 0;
        while(p != null){
            while(p.next!=null && p.val == p.next.val){
                occurs = 2;
                p = p.next;
            }
            if(occurs < 2){
                tail.next = p;
                tail = p;
            }
            p = p.next;
            occurs = 0;
        }
        tail.next = null;
        return firstNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        ListNode.printList(new Number82().deleteDuplicates(head));
    }
}
