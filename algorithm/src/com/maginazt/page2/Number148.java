package com.maginazt.page2;

import com.maginazt.common.ListNode;

/**
 * Created by zhaotao on 2016/8/30.
 */
public class Number148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while ((p2 = goTwo(p2)) != null)
            p1 = p1.next;
        ListNode otherHead = p1.next;
        p1.next = null;
        head = sortList(head);
        otherHead = sortList(otherHead);
        return merge(head, otherHead);
    }

    private ListNode merge(ListNode head, ListNode otherHead) {
        ListNode p1 = head;
        ListNode p2 = otherHead;
        ListNode result = null;
        ListNode tail = null;
        while (p1 != null && p2 != null){
            ListNode next;
            if(p1.val < p2.val){
                next = p1;
                p1 = p1.next;
            }
            else{
                next = p2;
                p2 = p2.next;
            }
            if(result == null){
                result = next;
                tail = next;
            }
            else{
                tail.next = next;
                tail = next;
            }
        }
        if(p1 != null)
            tail.next = p1;
        if(p2 != null)
            tail.next = p2;
        return result;
    }

    private ListNode goTwo(ListNode p2) {
        if(p2.next == null || p2.next.next == null)
            return null;
        return p2.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(9);
        ListNode.printList(new Number148().sortList(head));
    }
}
