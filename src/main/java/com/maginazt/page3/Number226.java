package com.maginazt.page3;

import com.maginazt.structure.TreeNode;

/**
 * Created by zhaotao on 2016/9/19.
 */
public class Number226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {

    }
}
