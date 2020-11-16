package com.maginazt.page2;

import java.util.*;

/**
 * Created by zhaotao on 2016/9/5.
 */
public class Number187 {

    private static final Map<Integer, Integer> stringMap = new HashMap<>();
    private static final char[] map = new char[26];

    static {
        //A - 00
        map[0] = 0b0;
        //C
        map['C'-'A'] = 0b1;
        //G
        map['G'-'A'] = 0b10;
        //T
        map['T'-'A'] = 0b11;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        LinkedList<String> result = new LinkedList<>();
        if(s.length() > 10){
            stringMap.clear();
            for(int i=10;i<=s.length();i++){
                int fingerprint = 0;
                for(int k=i-10;k<i;k++){
                    fingerprint |= map[s.charAt(k)-'A'] << 2*(i-k-1);
                }
                if(!stringMap.containsKey(fingerprint))
                    stringMap.put(fingerprint, 1);
                else{
                    int nums = stringMap.get(fingerprint);
                    if(nums == 1)
                        result.addLast(s.substring(i-10, i));
                    stringMap.put(fingerprint, nums+1);
                }
            }
        }
        return result;
    }

//    public List<String> findRepeatedDnaSequences(String s) {
//        LinkedList<String> result = new LinkedList<>();
//        if(s.length() > 10){
//            stringMap.clear();
//            char[] c = new char[10];
//            for(int i=10;i<=s.length();i++){
//                for(int k=0;k<10;k++)
//                    c[k] = s.charAt(i-10+k);
//                int hash = Arrays.hashCode(c);
//                if(!stringMap.containsKey(hash))
//                    stringMap.put(hash, 1);
//                else{
//                    int nums = stringMap.get(hash);
//                    if(nums == 1)
//                        result.addLast(new String(c));
//                    stringMap.put(hash, nums+1);
//                }
//            }
//            //check the result
//            int size = result.size();
//            for(int i=0;i<size;i++){
//                String r = result.removeFirst();
//                int a = s.indexOf(r);
//                if(a != -1){
//                    a = s.indexOf(r, a+1);
//                    if(a != -1)
//                        result.addLast(r);
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Number187().findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
