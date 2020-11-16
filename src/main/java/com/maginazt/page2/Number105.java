package com.maginazt.page2;

import com.maginazt.common.TreeNode;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex) {
        if(preStartIndex == preEndIndex)
            return new TreeNode(preorder[preStartIndex]);
        TreeNode root = new TreeNode(preorder[preStartIndex]);
        int rootIndex = inStartIndex;
        while (rootIndex < inEndIndex){
            if(inorder[rootIndex] == root.val)
                break;
            ++rootIndex;
        }
        if(rootIndex == inStartIndex){
            root.right = build(preorder, preStartIndex+1, preEndIndex, inorder, inStartIndex+1, inEndIndex);
        }
        else if(rootIndex == inEndIndex){
            root.left = build(preorder, preStartIndex+1, preEndIndex, inorder, inStartIndex, inEndIndex-1);
        }
        else{
            root.left = build(preorder, preStartIndex+1, preStartIndex+rootIndex-inStartIndex, inorder, inStartIndex, rootIndex-1);
            root.right = build(preorder, preStartIndex+rootIndex-inStartIndex+1, preEndIndex, inorder, rootIndex+1, inEndIndex);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Number105().buildTree(new int[]{1,2,5,3,4}, new int[]{2,5,1,4,3}));
    }
}
