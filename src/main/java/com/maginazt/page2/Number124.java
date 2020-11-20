package com.maginazt.page2;

import com.maginazt.structure.TreeNode;

/**
 * Created by zhaotao on 2016/8/18.
 */
public class Number124 {

    private static int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        if(root != null)
            findMaxPathSum(root);
        return maxPathSum;
    }

    private int findMaxPathSum(TreeNode root) {
        int maxPathSumLeft = 0;
        if(root.left != null)
            maxPathSumLeft = findMaxPathSum(root.left);
        int maxPathSumRight = 0;
        if(root.right != null)
            maxPathSumRight = findMaxPathSum(root.right);
        int currentMax = Math.max(root.val, root.val + maxPathSumLeft);
        currentMax = Math.max(currentMax, root.val + maxPathSumRight);
        if(currentMax > maxPathSum)
            maxPathSum = currentMax;
        if(root.val + maxPathSumLeft + maxPathSumRight > maxPathSum)
            maxPathSum = root.val + maxPathSumLeft + maxPathSumRight;
        return currentMax;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new Number124().maxPathSum(root));
    }
}
