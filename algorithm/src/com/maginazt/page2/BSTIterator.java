package com.maginazt.page2;

import com.maginazt.common.TreeNode;

/**
 * Created by zhaotao on 2016/9/2.
 */
public class BSTIterator {

    public BSTIterator(TreeNode root) {

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return 1;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */