package com.maginazt.page1;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Number28 {

    public int strStr(String haystack, String needle) {
        if(haystack!=null){
            if(null == needle || "".equals(needle))
                return 0;
            char[] source = haystack.toCharArray();
            char[] target = needle.toCharArray();
            for(int s = 0;s < source.length;s++){
                int sp = s;
                int t = 0;
                while (sp < source.length && t < target.length && source[sp] == target[t]){
                    ++sp;
                    ++t;
                }
                if(t == target.length)
                    return s;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Number28().strStr("", "a"));
    }
}
