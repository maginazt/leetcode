package com.maginazt.page11;

import com.maginazt.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zhaotao
 * @date: 2020/11/20 09:28
 */
public class Number1038 {

    public TreeNode bstToGst(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode prev = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                while (p.right != null) {
                    stack.push(p);
                    p = p.right;
                }
            } else {
                p = stack.pop();
            }
            if (prev != null) {
                p.val += prev.val;
            }
            prev = p;
            p = p.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Number1038 number1038 = new Number1038();
        TreeNode treeNode1 = TreeNode.build(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        System.out.println(number1038.bstToGst(treeNode1));
        TreeNode treeNode2 = TreeNode.build(Arrays.asList(0, null, 1));
        System.out.println(number1038.bstToGst(treeNode2));
        TreeNode treeNode3 = TreeNode.build(Arrays.asList(1, 0, 2));
        System.out.println(number1038.bstToGst(treeNode3));
        TreeNode treeNode4 = TreeNode.build(Arrays.asList(3, 2, 4, 1));
        System.out.println(number1038.bstToGst(treeNode4));
    }
}
