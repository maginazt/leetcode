package com.maginazt.page2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/26.
 */
public class Number131 {

    public List<List<String>> partition(String s) {
        if(s != null && s.length() > 0){
            List<List<String>>[] cache = new List[s.length()];
            return doPartition(s, 0, cache);
        }
        else
            return new ArrayList<>();
    }

    private List<List<String>> doPartition(String s, int startIndex, List<List<String>>[] cache) {
        if(cache[startIndex] != null)
            return cache[startIndex];
        List<List<String>> result = new ArrayList<>();
        for(int end=startIndex;end<s.length();end++){
            if(isPalindrome(s, startIndex, end)){
                String palin = s.substring(startIndex, end+1);
                if(end < s.length()-1){
                    List<List<String>> lists = doPartition(s, end+1, cache);
                    for(List<String> list : lists){
                        List<String> newList = new ArrayList<>();
                        newList.add(palin);
                        newList.addAll(list);
                        result.add(newList);
                    }
                }
                else{
                    List<String> whole = new ArrayList<>();
                    whole.add(palin);
                    result.add(whole);
                }
            }
        }
        cache[startIndex] = result;
        return result;
    }

    private boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            ++start;
            --end;
        }
        return true;
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        new Number131().partition("aabbaaaabbaaaabbaaaabbaabbaaaabbaaaabbaaaabb");
//        System.out.println("time: "+(System.currentTimeMillis()-start));
        System.out.println("aabbaaaabbaaaabbaaaabbaabbaaaabbaaaabbaaaabb".length());
    }
}
