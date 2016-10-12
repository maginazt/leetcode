package com.maginazt.page3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/10/9.
 */
public class Number290 {

    private static final String[] map = new String[26];
    private static final Map<String, Integer> reverseMap = new HashMap<>();

    public boolean wordPattern(String pattern, String str) {
        Arrays.fill(map, null);
        reverseMap.clear();
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length)
            return false;
        for(int i=0;i<strings.length;i++){
            int key = pattern.charAt(i) - 'a';
            if(map[key] == null){
                if(!reverseMap.containsKey(strings[i])){
                    map[key] = strings[i];
                    reverseMap.put(strings[i], key);
                }
                else
                    return false;
            }
            else
                if(!reverseMap.containsKey(strings[i]) || !reverseMap.get(strings[i]).equals(key))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        "abba"
//        "dog dog dog dog"
        System.out.println(new Number290().wordPattern("abba", "dog cat cat fish"));
    }
}
