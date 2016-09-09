package com.maginazt.page2;

import com.maginazt.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number199 {

    private static final LinkedList<TreeNode> queue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            queue.clear();
            queue.addLast(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                TreeNode last = null;
                for(int i=0;i<size;i++){
                    last = queue.removeFirst();
                    if(last.left != null)
                        queue.addLast(last.left);
                    if(last.right != null)
                        queue.addLast(last.right);
                }
                result.add(last.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        System.out.println(new Number199().rightSideView(root));
    }
}
