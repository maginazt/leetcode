package com.maginazt.page2;

import com.maginazt.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            boolean isSequence = true;
            while(!queue.isEmpty()){
                int total = queue.size();
                List<Integer> level = new ArrayList<>();
                if(isSequence){
                    for(int i=0;i<total;i++){
                        TreeNode t = queue.pollFirst();
                        level.add(t.val);
                        if(t.left != null)
                            queue.addLast(t.left);
                        if(t.right != null)
                            queue.addLast(t.right);
                    }
                }
                else{
                    for(int i=0;i<total;i++){
                        TreeNode t = queue.pollLast();
                        level.add(t.val);
                        if(t.right!=null)
                            queue.addFirst(t.right);
                        if(t.left != null)
                            queue.addFirst(t.left);
                    }
                }
                result.add(level);
                isSequence = !isSequence;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
