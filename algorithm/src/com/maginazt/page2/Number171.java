package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/2.
 */
public class Number171 {

    public int titleToNumber(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            result = result*26+(s.charAt(i)-'A'+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number171().titleToNumber("Z"));
    }
}
