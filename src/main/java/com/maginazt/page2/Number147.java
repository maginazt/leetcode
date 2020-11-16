package com.maginazt.page2;

import com.maginazt.common.ListNode;

/**
 * Created by zhaotao on 2016/8/30.
 */
public class Number147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode(Integer.MIN_VALUE);
        first.next = head;
        if(head != null && head.next != null){
            ListNode p = head.next;
            head.next = null;
            ListNode prev;
            ListNode c;
            while (p != null){
                prev = first;
                c = first.next;
                while (c != null && p.val > c.val){
                    prev = c;
                    c = c.next;
                }
                ListNode next = p.next;
                p.next = prev.next;
                prev.next = p;
                p = next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        ListNode.printList(new Number147().insertionSortList(head));
    }
}
