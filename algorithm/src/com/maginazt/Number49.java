package com.maginazt;

import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Number49 {

    private static final int[] dictionary = new int[26];

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String str : strs){
            String hash = getHash(str);
            if(map.containsKey(hash)){
                result.get(map.get(hash)).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map.put(hash, result.size()-1);
            }
        }
        return result;
    }

    private String getHash(String str) {
        if(str.length()==0)
            return "";
        for(int i=0;i<dictionary.length;i++)
            dictionary[i] = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++)
            dictionary[str.charAt(i)-'a']++;
        for(int i=0;i<dictionary.length;i++)
            if(dictionary[i]>0)
                sb.append(i).append(dictionary[i]).append('-');
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(new Number49().getHash(""));
        System.out.println(new Number49().groupAnagrams(new String[]{"chubby", "rummy"}));
//        Set<String> s1 = fromStr(new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\s1.txt")).readLine());
//        Set<String> s2 = fromStr(new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\s2.txt")).readLine());
//        for(String str2 : s2)
//            if(!s1.contains(str2))
//                System.out.println(str2);
    }

    public static Set<String> fromStr(String str){
        Set<String> result = new HashSet<>();
        int start = 0;
        int end = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '[')
                start = i;
            if(str.charAt(i) == ']'){
                end = i;
                result.add(str.substring(start, end+1));
            }
        }
        return result;
    }
}
