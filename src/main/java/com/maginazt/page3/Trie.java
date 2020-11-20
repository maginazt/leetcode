package com.maginazt.page3;

import com.maginazt.structure.TrieNode;

/**
 * Created by zhaotao on 2016/9/7.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word != null){
            TrieNode current = root;
            for(int i=0;i<word.length();i++){
                int ch = word.charAt(i) - 'a';
                if(current.nexts[ch] != null){
                    current = current.nexts[ch];
                    if(i == word.length()-1)
                        current.isWord = true;
                }
                else{
                    TrieNode next = new TrieNode();
                    if(i == word.length()-1)
                        next.isWord = true;
                    current.nexts[ch] = next;
                    current = next;
                }
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word != null){
            TrieNode current = root;
            for(int i=0;i<word.length();i++){
                int ch = word.charAt(i) - 'a';
                if(current.nexts[ch] != null)
                    current = current.nexts[ch];
                else
                    return false;
            }
            return current.isWord;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix != null){
            TrieNode current = root;
            int index = 0;
            while (index < prefix.length() && current != null){
                int ch = prefix.charAt(index) - 'a';
                current = current.nexts[ch];
                ++index;
            }
            return current != null;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("she");
//        trie.insert("sells");
//        trie.insert("sea");
//        trie.insert("shells");
//        trie.insert("by");
//        trie.insert("the");
//        trie.insert("sea");
//        trie.insert("shore");
//        System.out.println(trie.search("sell"));
//        System.out.println(trie.search("she"));
//        System.out.println(trie.startsWith("c"));
        trie.insert("abc");
        trie.insert("ab");
        System.out.println(trie.search("ab"));
    }
}
