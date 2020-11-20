package com.maginazt.page3;

import com.maginazt.structure.TreeNode;

import java.util.LinkedList;

/**
 * Created by zhaotao on 16/9/25.
 */
public class Number230 {

    private static final LinkedList<TreeNode> queue = new LinkedList<>();

    public int kthSmallest(TreeNode root, int k) {
        int numberLessThan = count(root.left);
        int position = numberLessThan + 1;
        if(position == k)
            return root.val;
        else if(k < position)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k-position);
    }

    private int count(TreeNode root) {
        if(root == null)
            return 0;
        int result = 0;
        queue.clear();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            ++result;
            if(node.left != null)
                queue.addLast(node.left);
            if(node.right != null)
                queue.addLast(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
