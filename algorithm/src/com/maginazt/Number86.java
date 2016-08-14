package com.maginazt;

/**
 * Created by zhaotao on 16/8/14.
 */
public class Number86 {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode lessPointer = lessHead;
        ListNode morePointer = moreHead;
        ListNode p = head;
        while (p != null){
            if(p.val < x){
                lessPointer.next = p;
                lessPointer = p;
            }
            else{
                morePointer.next = p;
                morePointer = p;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        if(lessHead.next == null)
            return moreHead.next;
        else{
            lessPointer.next = moreHead.next;
            return lessHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode.printList(new  Number86().partition(head, 3));
    }
}
