package com.maginazt.page2;

import com.maginazt.structure.TreeNode;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0 || postorder.length != inorder.length)
            return null;
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int inStartIndex, int inEndIndex, int[] postorder, int poStartIndex, int poEndIndex) {
        if(poStartIndex == poEndIndex)
            return new TreeNode(postorder[poStartIndex]);
        TreeNode root = new TreeNode(postorder[poEndIndex]);
        int rootIndex = inStartIndex;
        while (rootIndex < inEndIndex){
            if(inorder[rootIndex] == root.val)
                break;
            ++rootIndex;
        }
        if(rootIndex == inStartIndex){
            root.right = build(inorder, inStartIndex+1, inEndIndex, postorder, poStartIndex, poEndIndex-1);
        }
        else if(rootIndex == inEndIndex){
            root.left = build(inorder, inStartIndex, inEndIndex-1, postorder, poStartIndex, poEndIndex-1);
        }
        else{
            root.left = build(inorder, inStartIndex, rootIndex-1, postorder, poStartIndex, poStartIndex+rootIndex-inStartIndex-1);
            root.right = build(inorder, rootIndex+1, inEndIndex, postorder, poEndIndex-inEndIndex+rootIndex, poEndIndex-1);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Number106().buildTree(new int[]{2,5,1,4,3}, new int[]{5,2,4,3,1}));
    }
}
