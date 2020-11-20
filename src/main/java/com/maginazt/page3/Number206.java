package com.maginazt.page3;

import com.maginazt.structure.ListNode;

/**
 * Created by zhaotao on 2016/9/7.
 */
public class Number206 {

//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//        ListNode p = head;
//        ListNode next = p.next;
//        p.next = null;
//        while (next != null){
//            ListNode after = next.next;
//            next.next = p;
//            p = next;
//            next = after;
//        }
//        return p;
//    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head.next;
        ListNode first = reverse(head.next);
        prev.next = head;
        head.next = null;
        return first;
    }

    private ListNode reverse(ListNode node) {
        if(node.next != null){
            ListNode prev = node.next;
            ListNode first = reverse(node.next);
            prev.next = node;
            return first;
        }
        else
            return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        ListNode.printList(new Number206().reverseList(head));
    }
}
