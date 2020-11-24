package com.maginazt.structure;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode create(List<Integer> vals) {
        if (vals == null || vals.isEmpty()) {
            return null;
        }
        ListNode root = new ListNode(vals.get(0));
        ListNode pre = root;
        for (int i = 1; i < vals.size(); i++) {
            ListNode p = new ListNode(vals.get(i));
            pre.next = p;
            pre = p;
        }
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode p = next;
        while (p != null) {
            sb.append("->").append(p.val);
            p = p.next;
        }
        return sb.toString();
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }
}