package com.maginazt.common;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(this);
        while(!allNull(queue)){
            TreeNode node = queue.pollFirst();
            if(node != null){
                sb.append(node.val).append(",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
            else
                sb.append("null,");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    private boolean allNull(Deque<TreeNode> queue) {
        if(queue.isEmpty())
            return true;
        for(TreeNode node : queue){
            if(node != null)
                return false;
        }
        return true;
    }
}