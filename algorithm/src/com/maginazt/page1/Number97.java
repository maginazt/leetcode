package com.maginazt.page1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number97 {

    private static final Map<String, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if("".equals(s1))
            return s2.equals(s3);
        if("".equals(s2))
            return s1.equals(s3);
        if(s1.length() + s2.length() != s3.length())
            return false;
        cache.clear();
        return isInterleave(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    private boolean isInterleave(char[] first, int firstIndex, char[] second, int secondIndex, char[] target, int index) {
        System.out.println("("+firstIndex+","+secondIndex+","+index+")");
        String key = firstIndex+"-"+secondIndex+"-"+index;
        if(cache.containsKey(key))
            return cache.get(key);
        while (firstIndex < first.length && secondIndex < second.length && first[firstIndex] != second[secondIndex]){
            if(first[firstIndex] == target[index]){
                ++firstIndex;
                ++index;
            }
            else if(second[secondIndex] == target[index]){
                ++secondIndex;
                ++index;
            }
            else{
                key = firstIndex+"-"+secondIndex+"-"+index;
                cache.put(key, false);
                return false;
            }
        }
        key = firstIndex+"-"+secondIndex+"-"+index;
        if(cache.containsKey(key))
            return cache.get(key);
        if(firstIndex == first.length){
            boolean result = isEqual(second, secondIndex, target, index);
            cache.put(key, result);
            return result;
        }
        else if(secondIndex == second.length){
            boolean result = isEqual(first, firstIndex, target, index);
            cache.put(key, result);
            return result;
        }
        else if(first[firstIndex] != target[index]){
            cache.put(key, false);
            return false;
        }
        else{
            boolean result = isInterleave(first, firstIndex+1, second, secondIndex, target, index+1) || isInterleave(first, firstIndex, second, secondIndex+1, target, index+1);
            cache.put(key, result);
            return result;
        }
    }

    private boolean isEqual(char[] source, int sourceIndex, char[] target, int targetIndex) {
        int charsLeft = source.length - sourceIndex;
        for(int i=0;i<charsLeft;i++){
            if(source[sourceIndex+i] != target[targetIndex+i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number97().isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
