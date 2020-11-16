package com.maginazt.page2;

import com.maginazt.common.ListNode;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/8/29.
 */
public class Number143 {

    private static final LinkedList<ListNode> deque = new LinkedList<>();

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        deque.clear();
        ListNode p = head;
        while (p != null){
            ListNode c = p;
            deque.addLast(c);
            p = p.next;
            c.next = null;
        }
        ListNode tail = null;
        while (!deque.isEmpty()){
            ListNode a = deque.removeFirst();
            if(tail == null)
                tail = a;
            else{
                tail.next = a;
                tail = a;
            }
            if(!deque.isEmpty()){
                ListNode b = deque.removeLast();
                tail.next = b;
                tail = b;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Number143().reorderList(head);
        ListNode.printList(null);
    }
}
