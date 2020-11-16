package com.maginazt.page3;

import com.maginazt.common.TreeNode;

/**
 * Created by zhaotao on 2016/9/18.
 */
public class Number222 {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int h = height(root);
        int base = 1 << (h-1);
        int offset = 0;
        TreeNode p = root;
        while (p.left != null || p.right != null){
            int hl = height(p.left);
            int hr = height(p.right);
            if(hl == hr){
                base >>= 1;
                offset += base;
                p = p.right;
            }
            else{
                base >>= 1;
                p = p.left;
            }
        }
        return (1 << (h-1)) + offset;
    }

    private int height(TreeNode root){
        int height = 0;
        while (root != null){
            ++height;
            root = root.left;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(1);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(1);
//        root.left.right.left = new TreeNode(1);
//        root.left.right.right = new TreeNode(1);
        System.out.println(new Number222().countNodes(root));
    }
}
