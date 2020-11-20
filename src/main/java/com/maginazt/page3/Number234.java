package com.maginazt.page3;

import com.maginazt.structure.ListNode;

/**
 * Created by zhaotao on 2016/9/28.
 */
public class Number234 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        int length = getLength(head);
        ListNode leftHead;
        ListNode rightHead;
        ListNode p = head;
        int step = length / 2;
        while (step > 1){
            p = p.next;
            --step;
        }
        boolean result;
        if(length % 2 == 0){
            leftHead = p;
            rightHead = p.next;
            leftHead.next = null;
            reverseList(head);
            result = judge(leftHead, rightHead);
            reverseList(leftHead);
            leftHead.next = rightHead;
        }
        else{
            leftHead = p;
            rightHead = p.next.next;
            ListNode mid = p.next;
            leftHead.next = null;
            reverseList(head);
            result = judge(leftHead, rightHead);
            reverseList(leftHead);
            leftHead.next = mid;
        }
        return result;
    }

    private boolean judge(ListNode leftHead, ListNode rightHead) {
        while (leftHead != null){
            if(leftHead.val != rightHead.val)
                return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    private int getLength(ListNode head) {
        int result = 0;
        while (head != null){
            ++result;
            head = head.next;
        }
        return result;
    }

    private ListNode reverseList(ListNode head) {
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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(new Number234().isPalindrome(head));
    }
}
