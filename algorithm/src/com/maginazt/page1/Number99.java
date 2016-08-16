package com.maginazt.page1;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number99 {

    public static final int LEFT = 1;
    public static final int RIGHT = 2;

    private static final LinkedList<TreeNode> stack = new LinkedList<>();

    public void recoverTree(TreeNode root) {
        TreeNode wrongLeft = check(root.left, root.val, LEFT);
        TreeNode wrongRight = check(root.right, root.val, RIGHT);
        if(wrongLeft != null && wrongRight != null){
            int tmp = wrongLeft.val;
            wrongLeft.val = wrongRight.val;
            wrongRight.val = tmp;
        }
        else if(wrongLeft != null){
            TreeNode maxNode = findMax(root.left);
            int tmp = maxNode.val;
            maxNode.val = root.val;
            root.val = tmp;
        }
        else if(wrongRight != null){
            TreeNode minNode = findMin(root.right);
            int tmp = minNode.val;
            minNode.val = root.val;
            root.val = tmp;
        }
        else{
            if(root.left != null)
                recoverTree(root.left);
            if(root.right != null)
                recoverTree(root.right);
        }
    }

    private TreeNode findMin(TreeNode root) {
        stack.clear();
        TreeNode min = null;
        int minValue = Integer.MAX_VALUE;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                current = stack.pop();
                if(current.val < minValue){
                    min = current;
                    minValue = current.val;
                }
                current = current.right;
            }
        }
        return min;
    }

    private TreeNode findMax(TreeNode root) {
        stack.clear();
        TreeNode max = null;
        int maxVal = Integer.MIN_VALUE;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                current = stack.pop();
                if(current.val > maxVal){
                    max = current;
                    maxVal = current.val;
                }
                current = current.right;
            }
        }
        return max;
    }

    private TreeNode check(TreeNode root, int val, int direction) {
        if(root == null)
            return null;
        if(direction == LEFT)
            return isAllLess(root, val);
        else
            return isAllGreater(root, val);
    }

    private TreeNode isAllGreater(TreeNode root, int val) {
        stack.clear();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                current = stack.pop();
                if(current.val < val)
                    return current;
                current = current.right;
            }
        }
        return null;
    }

    private TreeNode isAllLess(TreeNode root, int val) {
        stack.clear();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                current = stack.pop();
                if(current.val > val)
                    return current;
                current = current.right;
            }
        }
        return null;
    }
}
