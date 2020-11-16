package com.maginazt.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void printList(ListNode head){
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }
}