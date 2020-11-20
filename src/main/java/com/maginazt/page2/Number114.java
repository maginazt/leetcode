package com.maginazt.page2;

import com.maginazt.structure.TreeNode;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number114 {

    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private TreeNode doFlatten(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tail = root;
        TreeNode leftHead = root.left;
        TreeNode leftTail = doFlatten(root.left);
        TreeNode rightHead = root.right;
        TreeNode rightTail = doFlatten(root.right);
        if(leftTail != null){
            tail.left = null;
            tail.right = leftHead;
            tail = leftTail;
        }
        if(rightTail != null){
            tail.left = null;
            tail.right = rightHead;
            tail = rightTail;
        }
        return tail;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Number114().flatten(root);
        System.out.println(root);
    }
}
