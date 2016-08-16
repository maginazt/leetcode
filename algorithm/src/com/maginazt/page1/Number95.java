package com.maginazt.page1;

import com.maginazt.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number95 {

    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int begin, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(begin == end)
            result.add(new TreeNode(begin));
        else{
            for(int i=begin;i<=end;i++){
                List<TreeNode> leftTrees = null;
                //has left trees
                if(i>begin){
                    leftTrees = buildTrees(begin, i-1);
                }
                List<TreeNode> rightTrees = null;
                //has right trees
                if(i<end){
                    rightTrees = buildTrees(i+1, end);
                }
                if(leftTrees != null && rightTrees != null){
                    for(TreeNode leftRoot : leftTrees)
                        for(TreeNode rightRoot : rightTrees){
                            TreeNode root = new TreeNode(i);
                            root.left = leftRoot;
                            root.right = rightRoot;
                            result.add(root);
                        }
                }
                else if(leftTrees != null){
                    for(TreeNode leftRoot : leftTrees){
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        result.add(root);
                    }
                }
                else{
                    for(TreeNode rightRoot : rightTrees){
                        TreeNode root = new TreeNode(i);
                        root.right = rightRoot;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(2);
//        System.out.println(root.toString());
//        System.out.println("=================================");
//        TreeNode r = new TreeNode(1);
//        r.right = new TreeNode(2);
//        r.right.right = new TreeNode(3);
//        System.out.println(r.toString());
        System.out.println(new Number95().generateTrees(3));
    }
}
