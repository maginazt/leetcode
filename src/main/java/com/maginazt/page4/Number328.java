package com.maginazt.page4;

import com.maginazt.structure.ListNode;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/1 15:26
 */
public class Number328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = null;
        ListNode evenHead = null;
        ListNode even = null;
        int index = 1;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (index % 2 == 1) {
                if (odd == null) {
                    odd = p;
                } else {
                    odd.next = p;
                    odd = p;
                }
            } else {
                if (even == null) {
                    even = p;
                    evenHead = p;
                } else {
                    even.next = p;
                    even = p;
                }
            }
            p.next = null;
            ++index;
            p = next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Number328 number328 = new Number328();
        System.out.println(number328.oddEvenList(ListNode.create(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println(number328.oddEvenList(ListNode.create(Arrays.asList(2, 1, 3, 5, 6, 4, 7))));
    }
}
