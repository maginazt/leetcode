package com.maginazt.page2;

import com.maginazt.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/30.
 */
public class Number145 {

    private static final LinkedList<TreeNode> stack = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            stack.clear();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if(node.left != null)
                    stack.push(node.left);
                if(node.right != null)
                    stack.push(node.right);
            }
            Collections.reverse(result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Number145().postorderTraversal(root));
    }
}
