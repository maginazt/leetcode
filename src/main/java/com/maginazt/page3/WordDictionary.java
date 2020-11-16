package com.maginazt.page3;

import com.maginazt.common.TrieNode;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/8.
 */
public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    private static final LinkedList<TrieNode> queue = new LinkedList<>();

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word != null){
            queue.clear();
            queue.addLast(root);
            for(int i=0;i<word.length();i++) {
                int ch = word.charAt(i);
                int size = queue.size();
                for(int n=0;n<size;n++){
                    TrieNode node = queue.removeFirst();
                    if(ch != '.'){
                        if(node.nexts[ch-'a'] != null)
                            queue.addLast(node.nexts[ch-'a']);
                    }
                    else{
                        for(int p=0;p<node.nexts.length;p++)
                            if(node.nexts[p] != null)
                                queue.addLast(node.nexts[p]);
                    }
                }
                if(queue.isEmpty())
                    return false;
            }
            for(TrieNode end : queue)
                if(end.isWord)
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("abc");
        wordDictionary.addWord("ab");
        System.out.println(wordDictionary.search(""));
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");