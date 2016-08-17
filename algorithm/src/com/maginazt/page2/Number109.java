package com.maginazt.page2;

import com.maginazt.common.ListNode;
import com.maginazt.common.TreeNode;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number109 {

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        int length = 0;
        ListNode p = head;
        while(p!=null){
            ++length;
            p = p.next;
        }
        node = head;
        return build(0, length-1);
    }

    private TreeNode build(int start, int end) {
        if(start > end)
            return null;
        else{
            int mid = start + (end-start)/2;
            TreeNode left = build(start, mid-1);
            TreeNode root = new TreeNode(node.val);
            node = node.next;
            TreeNode right = build(mid+1, end);
            root.left = left;
            root.right = right;
            return root;
        }
    }

//    private static final Map<TreeNode, Integer> heights = new HashMap<>();
//
//    public TreeNode sortedListToBST(ListNode head) {
//        if(head == null)
//            return null;
//        TreeNode root = new TreeNode(head.val);
//        if(head.next == null)
//            return root;
//        heights.clear();
//        heights.put(root, 1);
//        ListNode p = head.next;
//        while (p != null){
//            root = add(p.val, root);
//            p = p.next;
//        }
//        return root;
//    }

//    private TreeNode add(int val, TreeNode root) {
//        if(root == null)
//            root = new TreeNode(val);
//        //insert to the left
//        if(val < root.val){
//            root.left = add(val, root.left);
//            if(getHeight(root.left) - getHeight(root.right) >= 2){
//                //LL
//                if(val < root.left.val)
//                    root = rotateLL(root);
//                //LR
//                else
//                    root = rotateLR(root);
//            }
//        }
//        //insert to the right
//        if(val > root.val){
//            root.right = add(val, root.right);
//            if(getHeight(root.right) - getHeight(root.left) >= 2){
//                //RR
//                if(val > root.right.val)
//                    root = rotateRR(root);
//                //RL
//                else
//                    root = rotateRL(root);
//            }
//        }
//        heights.put(root, Math.max(getHeight(root.left), getHeight(root.right))+1);
//        return root;
//    }
//
//    private TreeNode rotateRL(TreeNode root) {
//        root.right = rotateLL(root.right);
//        return rotateRR(root);
//    }
//
//    private TreeNode rotateLR(TreeNode root) {
//        root.left = rotateRR(root.left);
//        return rotateLL(root);
//    }
//
//    private TreeNode rotateRR(TreeNode root) {
//        //new root node
//        TreeNode top = root.right;
//        root.right = top.left;
//        top.left = root;
//        heights.put(root, Math.max(getHeight(root.left), getHeight(root.right))+1);
//        heights.put(top, Math.max(getHeight(top.left), getHeight(top.right))+1);
//        return top;
//    }
//
//    private TreeNode rotateLL(TreeNode root) {
//        //new root node
//        TreeNode top = root.left;
//        root.left = top.right;
//        top.right = root;
//        heights.put(root, Math.max(getHeight(root.left), getHeight(root.right))+1);
//        heights.put(top, Math.max(getHeight(top.left), getHeight(top.right))+1);
//        return top;
//    }
//
//    private int getHeight(TreeNode root){
//        return root == null ? 0 : heights.get(root);
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(new Number109().sortedListToBST(head));
    }
}
