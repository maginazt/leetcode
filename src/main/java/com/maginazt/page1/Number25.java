package com.maginazt.page1;

import com.maginazt.structure.ListNode;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Number25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        if(k <= 1)
            return head;
        //additionally add a guard node to maintain consistency
        ListNode guard = new ListNode(0);
        //last successfully reversed segment's tail node
        ListNode preSegment = guard;
        //next segment's head node that to be reversed
        ListNode nextSegment = head;
        //the last segment's head node that needs to be recovered
        ListNode lastSegHead = null;
        while(nextSegment != null){
            //current working pointer
            ListNode p = nextSegment;
            //current segment's tail node
            ListNode tail = p;
            //how many nodes have been reversed
            int step = 1;
            //next node's pointer
            ListNode n = p.next;
            //only one node is left, no actions need to be performed
            if(n == null){
                preSegment.next = p;
                break;
            }
            p.next = null;
            //temp next node
            ListNode t = n.next;
            while(n != null && step < k){
                n.next = p;
                p = n;
                n = t;
                if(t !=null)
                    t = t.next;
                ++step;
            }
            //need to be recovered
            if(step < k){
                lastSegHead = p;
                break;
            }
            else{
                preSegment.next = p;
                preSegment = tail;
                nextSegment = n;
            }
        }
        //do reverse one more
        if(lastSegHead != null){
            ListNode p = lastSegHead;
            //next node's pointer
            ListNode n = p.next;
            p.next = null;
            //temp next node
            ListNode t = n.next;
            while(n != null){
                n.next = p;
                p = n;
                n = t;
                if(t !=null)
                    t = t.next;
            }
            preSegment.next = p;
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode.printList(new Number25().reverseKGroup(head, 7));
    }
}
