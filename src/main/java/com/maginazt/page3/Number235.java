package com.maginazt.page3;

import com.maginazt.structure.TreeNode;

/**
 * Created by zhaotao on 2016/9/28.
 */
public class Number235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    private boolean isIn(TreeNode root, TreeNode node) {
        if(root == null)
            return false;
        if(root.val == node.val)
            return true;
        else if(root.val < node.val)
            return isIn(root.right, node);
        else
            return isIn(root.left, node);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        System.out.println(new Number235().lowestCommonAncestor(root, p, q).val);
    }
}
