package com.maginazt.page3;

import com.maginazt.common.TreeNode;

/**
 * Created by zhaotao on 2016/9/28.
 */
public class Number236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
            return root;
        TreeNode leftParent = null;
        if(root.left != null)
            leftParent = lowestCommonAncestor(root.left, p, q);
        TreeNode rightParent = null;
        if(root.right != null)
            rightParent = lowestCommonAncestor(root.right, p, q);
        if(leftParent == null && rightParent == null)
            return null;
        else if(leftParent != null && rightParent != null)
            return root;
        else if(leftParent != null && rightParent == null)
            return leftParent;
        else
            return rightParent;
    }
}
