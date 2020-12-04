package com.maginazt.page2;

import com.maginazt.structure.ListNode;
import com.maginazt.structure.TreeNode;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number109 {

    private ListNode p;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        int length = count(head);
        p = head;
        return bst(0, length - 1);
    }

    private TreeNode bst(int begin, int end) {
        if (begin == end) {
            return buildTreeNode();
        }
        int mid = (begin + end) / 2;
        TreeNode left = null;
        if (begin < mid) {
            left = bst(begin, mid - 1);
        }
        TreeNode root = buildTreeNode();
        TreeNode right = null;
        if (mid < end) {
            right = bst(mid + 1, end);
        }
        root.left = left;
        root.right = right;
        return root;
    }

    private TreeNode buildTreeNode() {
        TreeNode treeNode = new TreeNode(p.val);
        p = p.next;
        return treeNode;
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            ++count;
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Number109 number109 = new Number109();
        System.out.println(number109.sortedListToBST(ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));
        System.out.println(number109.sortedListToBST(ListNode.create(Arrays.asList(-10, -3, 0, 5, 9))));
        System.out.println(number109.sortedListToBST(ListNode.create(Arrays.asList(1, 3))));
    }
}
