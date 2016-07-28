package com.maginazt;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Number61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int length = 1;
        ListNode p = head;
        while(p.next!=null){
            ++length;
            p = p.next;
        }
        ListNode tail = p;
        int actualShift = k % length;
        if(actualShift == 0)
            return head;
        ListNode result = null;
        int maxStep = length - actualShift - 1;
        int step = 0;
        p = head;
        while(step < maxStep){
            p = p.next;
            ++step;
        }
        result = p.next;
        p.next = null;
        tail.next = head;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.printList(new Number61().rotateRight(head,5));
    }
}
