package com.maginazt.page3;

import com.maginazt.common.TreeNode;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/10/11.
 */
public class Codec {

    private static final String NULL_STR = "null";
    private static final String SEPRATOR = ",";

    private static final LinkedList<TreeNode> queue = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        queue.clear();
        StringBuilder sb = new StringBuilder();
        queue.addLast(root);
        boolean lastLayer;
        while (!queue.isEmpty()){
            lastLayer = true;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.removeFirst();
                if(node != null){
                    sb.append(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                    if(node.left != null || node.right != null)
                        lastLayer = false;
                }
                else
                    sb.append(NULL_STR);
                sb.append(SEPRATOR);
            }
            if(lastLayer)
                break;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] strs = data.split(SEPRATOR);
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.clear();
        queue.addLast(root);
        int index = 1;
        while (index < strs.length){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.removeFirst();
                node.left = build(strs[index++]);
                if(node.left != null)
                    queue.addLast(node.left);
                node.right = build(strs[index++]);
                if(node.right != null)
                    queue.addLast(node.right);
            }
        }
        return root;
    }

    private TreeNode build(String str) {
        if(!NULL_STR.equals(str))
            return new TreeNode(Integer.parseInt(str));
        else
            return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.left.left = new TreeNode(9);
        TreeNode node = codec.deserialize(codec.serialize(root));
        System.out.println(node.toString());
    }
}
