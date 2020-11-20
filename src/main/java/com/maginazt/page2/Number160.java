package com.maginazt.page2;

import com.maginazt.structure.ListNode;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        int length1 = 1;
        ListNode p2 = headB;
        int length2 = 1;
        while (p1.next != null){
            ++length1;
            p1 = p1.next;
        }
        while (p2.next != null){
            ++length2;
            p2 = p2.next;
        }
        if(p1 != p2)
            return null;
        p1 = headA;
        p2 = headB;
        if(length1 < length2){
            int moves = length2 - length1;
            for(int i=0;i<moves;i++)
                p2 = p2.next;
        }
        else if(length1 > length2){
            int moves = length1 - length2;
            for(int i=0;i<moves;i++)
                p1 = p1.next;
        }
        ListNode result = null;
        while (true){
            if(p1 == p2){
                result = p1;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        ListNode tail = new ListNode(6);
        tail.next = new ListNode(7);
        head1.next.next = tail;
        head2.next.next.next = tail;
        System.out.println(new Number160().getIntersectionNode(head1, head2).val);
    }
}
