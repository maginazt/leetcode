package com.maginazt.page2;

import com.maginazt.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/29.
 */
public class Number144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(6);
        System.out.println(new Number144().preorderTraversal(root));
    }
}
