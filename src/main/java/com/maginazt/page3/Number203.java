package com.maginazt.page3;

import com.maginazt.structure.ListNode;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode p = head;
        ListNode prev = first;
        while (p != null){
            if(p.val == val){
                ListNode next = p.next;
                prev.next = next;
                p.next = null;
                p = next;
            }
            else{
                prev = p;
                p = p.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(6);
        ListNode.printList(new Number203().removeElements(null, 6));
    }
}
