package com.maginazt.page9;

import com.maginazt.structure.ListNode;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/1 08:54
 */
public class Number876 {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        Number876 number876 = new Number876();
        System.out.println(number876.middleNode(ListNode.create(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println(number876.middleNode(ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6))));
        System.out.println(number876.middleNode(ListNode.create(Arrays.asList(1))));
        System.out.println(number876.middleNode(ListNode.create(Arrays.asList(1, 2))));
    }
}
