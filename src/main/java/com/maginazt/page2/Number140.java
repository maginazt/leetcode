package com.maginazt.page2;

import java.util.*;

/**
 * Created by zhaotao on 2016/8/29.
 */
public class Number140 {

    private static List<String>[] cache;
    private static boolean[] isSolved;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        cache = new List[s.length()];
        isSolved = new boolean[s.length()];
        List<String> result = solve(s, wordDict, 0);
        if(result != null)
            return result;
        else
            return new ArrayList<>();
    }

    private List<String> solve(String s, Set<String> wordDict, int startIndex) {
        if(isSolved[startIndex])
            return cache[startIndex];
        List<String> result = null;
        for(int endIndex=s.length()-1;endIndex>startIndex;endIndex--){
            String prev = s.substring(startIndex, endIndex);
            if(wordDict.contains(prev)){
                List<String> nexts = solve(s, wordDict, endIndex);
                if(nexts != null){
                    if(result == null)
                        result = new ArrayList<>();
                    for(String next : nexts)
                        result.add(prev+" "+next);
                }
            }
        }
        String whole = s.substring(startIndex);
        if(wordDict.contains(whole)){
            if(result == null)
                result = new ArrayList<>();
            result.add(whole);
        }
        isSolved[startIndex] = true;
        cache[startIndex] = result;
        return result;
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(new Number140().wordBreak("catsanddog", wordDict));
    }
}
