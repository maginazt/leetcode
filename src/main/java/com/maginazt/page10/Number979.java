package com.maginazt.page10;

import com.maginazt.structure.TreeNode;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/16 13:28
 */
public class Number979 {

    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDis = distributeCoins(root.left);
        int rightDis = distributeCoins(root.right);
        if (root.left != null) {
            root.val += root.left.val - 1;
        }
        if (root.right != null) {
            root.val += root.right.val - 1;
        }
        return leftDis + rightDis + Math.abs(root.val - 1);
    }

    public static void main(String[] args) {
        Number979 number979 = new Number979();
        TreeNode treeNode1 = TreeNode.build(Arrays.asList(3, 0, 0));
        System.out.println(number979.distributeCoins(treeNode1));
        TreeNode treeNode2 = TreeNode.build(Arrays.asList(1, 0, 0, null, 3));
        System.out.println(number979.distributeCoins(treeNode2));
    }
}
