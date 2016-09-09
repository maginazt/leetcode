package com.maginazt.page3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/9/7.
 */
public class Number205 {

    private static final Map<Character, Character> map = new HashMap<>();
    private static final Map<Character, Character> revMap = new HashMap<>();

    public boolean isIsomorphic(String s, String t) {
        if(s.length() < 2)
            return true;
        map.clear();
        revMap.clear();
        for(int i=0;i<s.length();i++){
            char old = s.charAt(i);
            char neW = t.charAt(i);
            if(map.containsKey(old)){
                if(map.get(old) != neW)
                    return false;
            }
            else{
                if(revMap.containsKey(neW))
                    return false;
                else{
                    map.put(old, neW);
                    revMap.put(neW, old);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number205().isIsomorphic("ab", "aa"));
    }
}
