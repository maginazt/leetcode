package com.maginazt.page2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaotao on 2016/8/29.
 */
public class Number139 {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        int length = s.length();
        boolean[] results = new boolean[length+1];
        results[length] = true;
        for(int start=length-1;start>=0;start--){
            boolean result = false;
            for(int end=start;end<length;end++){
                if(wordDict.contains(s.substring(start, end+1)) && results[end+1]){
                    result = true;
                    break;
                }
            }
            results[start] = result;
        }
        return results[0];
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>(Arrays.asList("leet", "ode"));
        System.out.println(new Number139().wordBreak("leetcode", wordDict));
    }
}
