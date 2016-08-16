package com.maginazt.page1;

import java.util.Arrays;

/**
 * Created by zhaotao on 16/8/14.
 */
public class Number91 {

    private static int[] cache;

    public int numDecodings(String s) {
        if("".equals(s))
            return 0;
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        if(index == s.length())
            return 1;
        if(cache[index] >= 0){
            return cache[index];
        }
        int num = 0;
        if(s.charAt(index) != '0'){
            num += decode(s, index+1);
            if(index < s.length() - 1 && s.substring(index, index+2).compareTo("27") < 0)
                num += decode(s, index+2);
        }
        cache[index] = num;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Number91().numDecodings("102345678"));
    }

}
