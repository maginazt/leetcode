package com.maginazt.page2;

import com.maginazt.structure.TreeNode;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/2.
 */
public class BSTIterator {

    private LinkedList<TreeNode> stack;
    private TreeNode current;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null){
            stack.push(current);
            current = current.left;
        }
        TreeNode next = stack.pop();
        current = next.right;
        return next.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        BSTIterator b = new BSTIterator(root);
        while (b.hasNext()){
            System.out.println(b.next());
        }
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */