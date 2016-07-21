package com.maginazt;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Number23 {

    /**
     * loser tree
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        //loser tree implementation
        //none leaf node stores the index of leaf node(i.e. the loser)
        //root node index is 1
        //index of 0 stores the winner index of leaf node
        int[] ltree = new int[lists.length];
        //initialize none leaf nodes
        for(int i=0;i<ltree.length;i++)
            ltree[i] = -1;
        for(int i=lists.length-1;i>=0;i--){
            traceLoser(ltree, i, lists);
        }
        //do merge
        ListNode head = null;
        ListNode tail = null;
        while(lists[ltree[0]] != null){
            if(head == null){
                head = lists[ltree[0]];
                tail = head;
            }
            else{
                tail.next = lists[ltree[0]];
                tail = tail.next;
            }
            lists[ltree[0]] = lists[ltree[0]].next;
            traceLoser(ltree, ltree[0], lists);
        }
        return head;
    }

    private void traceLoser(int[] ltree, int leafIndex, ListNode[] lists) {
        int currentWinner = leafIndex;
        int parentIndex = (leafIndex + ltree.length)/2;
        while (parentIndex != 0){
            if(ltree[parentIndex] < 0){
                ltree[parentIndex] = currentWinner;
                break;
            }
            else{
                //current winner loses, change it
                if(lists[currentWinner] == null || (lists[ltree[parentIndex]] != null && lists[currentWinner].val >= lists[ltree[parentIndex]].val)){
                    int tmp = currentWinner;
                    currentWinner = ltree[parentIndex];
                    ltree[parentIndex] = tmp;
                }
                //continue to trace up
                parentIndex /= 2;
            }
        }
        if(parentIndex == 0)
            ltree[0] = currentWinner;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode l3 = new ListNode(8);
        l3.next = new ListNode(9);
        l3.next.next = new ListNode(10);
        ListNode.printList(new Number23().mergeKLists(new ListNode[]{l1, l2, l3}));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    static void printList(ListNode head){
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }
}
