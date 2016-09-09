package com.maginazt.common;

/**
 * Created by zhaotao on 2016/9/7.
 */
public class TrieNode {

    //whether it's an intermidate node or the last character node
    public boolean isWord;

    public TrieNode[] nexts;

    // Initialize your data structure here.
    public TrieNode() {
        nexts = new TrieNode[26];
    }
}
