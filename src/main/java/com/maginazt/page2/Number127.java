package com.maginazt.page2;

import java.util.*;

/**
 * Created by zhaotao on 2016/8/19.
 */
public class Number127 {

//    private static List<Integer> startIndexes = new ArrayList<>();
//    private static List<Integer> endIndexes = new ArrayList<>();
//
//    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
//        if(wordList.isEmpty())
//            return 0;
//        String[] words = new String[wordList.size()];
//        int index = 0;
//        for(String word : wordList)
//            words[index++] = word;
//        int[][] dists = parseDists(words);
//        startIndexes.clear();
//        endIndexes.clear();
//        if(wordList.contains(beginWord) && wordList.contains(endWord)){
//            int startIndex = 0;
//            int endIndex = 0;
//            for(int i=0;i<words.length;i++){
//                if(words[i].equals(beginWord))
//                    startIndex = i;
//                else if(words[i].equals(endWord))
//                    endIndex = i;
//            }
//            if(dists[startIndex][endIndex] == Integer.MAX_VALUE)
//                return 0;
//            return dists[startIndex][endIndex] + 1;
//        }
//        else if(wordList.contains(beginWord)){
//            int startIndex = 0;
//            for(int i=0;i<words.length;i++){
//                if(words[i].equals(beginWord))
//                    startIndex = i;
//                if(getDistance(endWord, words[i]) <= 1)
//                    endIndexes.add(i);
//            }
//            if(endIndexes.isEmpty())
//                return 0;
//            int minDist = Integer.MAX_VALUE;
//            for(int i=0;i<endIndexes.size();i++){
//                if(dists[startIndex][endIndexes.get(i)] < minDist)
//                    minDist = dists[startIndex][endIndexes.get(i)];
//            }
//            return minDist + 2;
//        }
//        else if(wordList.contains(endWord)){
//            int endIndex = 0;
//            for(int i=0;i<words.length;i++){
//                if(words[i].equals(endWord))
//                    endIndex = i;
//                if(getDistance(beginWord, words[i]) <= 1)
//                    startIndexes.add(i);
//            }
//            if(startIndexes.isEmpty())
//                return 0;
//            int minDist = Integer.MAX_VALUE;
//            for(int i=0;i<startIndexes.size();i++){
//                if(dists[startIndexes.get(i)][endIndex] < minDist)
//                    minDist = dists[startIndexes.get(i)][endIndex];
//            }
//            return minDist + 2;
//        }
//        else{
//            for(int i=0;i<words.length;i++){
//                if(getDistance(beginWord, words[i]) <= 1)
//                    startIndexes.add(i);
//                else if(getDistance(endWord, words[i]) <= 1)
//                    endIndexes.add(i);
//            }
//            if(startIndexes.isEmpty() || endIndexes.isEmpty())
//                return 0;
//            int minDist = Integer.MAX_VALUE;
//            for(int i=0;i<startIndexes.size();i++)
//                for(int j=0;j<endIndexes.size();j++){
//                    if(dists[startIndexes.get(i)][endIndexes.get(j)] < minDist)
//                        minDist = dists[startIndexes.get(i)][endIndexes.get(j)];
//                }
//            return minDist + 3;
//        }
//    }
//
//    private int[][] parseDists(String[] words) {
//        int[][] dists = new int[words.length][words.length];
//        for(int i=0;i<words.length;i++)
//            for(int j=i;j<words.length;j++){
//                if(i == j)
//                    dists[i][j] = 0;
//                else{
//                    dists[i][j] = getDistance(words[i], words[j]);
//                    dists[j][i] = dists[i][j];
//                }
//            }
//        for(int k=0;k<words.length;k++)
//            for(int i=0;i<words.length;i++)
//                for(int j=0;j<words.length;j++)
//                    if(dists[i][k] != Integer.MAX_VALUE && dists[k][j] != Integer.MAX_VALUE && dists[i][k]+dists[k][j] < dists[i][j])
//                        dists[i][j] = dists[i][k]+dists[k][j];
//        return dists;
//    }
//

    private static LinkedList<String> queue = new LinkedList<>();

//    private int getDistance(String word1, String word2) {
//        int diff = 0;
//        for(int i=0;i<word1.length();i++)
//            if(word1.charAt(i) != word2.charAt(i))
//                ++diff;
//        if(diff == 1)
//            return diff;
//        else
//            return Integer.MAX_VALUE;
//    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 1;
        queue.clear();
        queue.addLast(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);
        while(!queue.isEmpty()){
            //deal with this level
            int size = queue.size();
            for(int i=0;i<size;i++){
                char[] curWord = queue.getFirst().toCharArray();
                //wordList is so big that even enumerate all possible word is faster enough
                for(int c=0;c<curWord.length;c++){
                    for(char x='a';x<='z';x++){
                        char old = curWord[c];
                        curWord[c] = x;
                        String word = new String(curWord);
                        if(wordList.contains(word)){
                            if(word.equals(endWord))
                                return length+1;
                            else{
                                queue.addLast(word);
                                wordList.remove(word);
                            }
                        }
                        curWord[c] = old;
                    }
                }
                queue.removeFirst();
            }
            ++length;
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(new Number127().ladderLength("hit", "cog", wordList));
    }
}
