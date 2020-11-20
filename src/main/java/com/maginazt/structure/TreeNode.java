package com.maginazt.structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(List<Integer> vals) {
        if (vals == null || vals.isEmpty()) {
            return null;
        }
        TreeNode root = buildByVal(vals.get(0));
        if (root == null) {
            return null;
        }
        int valIndex = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (valIndex >= vals.size()) {
                break;
            }
            treeNode.left = buildByVal(vals.get(valIndex++));
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (valIndex >= vals.size()) {
                break;
            }
            treeNode.right = buildByVal(vals.get(valIndex++));
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return root;
    }

    private static TreeNode buildByVal(Integer val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(val);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(this);
        while (!allNull(queue)) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            } else
                sb.append("null,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private boolean allNull(Deque<TreeNode> queue) {
        if (queue.isEmpty())
            return true;
        for (TreeNode node : queue) {
            if (node != null)
                return false;
        }
        return true;
    }
}