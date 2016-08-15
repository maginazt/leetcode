package com.maginazt;

/**
 * Created by zhaotao on 2016/8/15.
 */
public class Number92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode rangeBefore = first;
        ListNode p = head;
        int index = 1;
        ListNode tail = null;
        for(int i=1;i<m;i++){
            p = p.next;
            rangeBefore = rangeBefore.next;
            ++index;
        }
        tail = p;
        ListNode next = p.next;
        while (index < n && next != null){
            ListNode t = next.next;
            next.next = p;
            p = next;
            next = t;
            ++index;
        }
        rangeBefore.next = p;
        tail.next = next;
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode.printList(new Number92().reverseBetween(head, 1, 1));
    }
}
