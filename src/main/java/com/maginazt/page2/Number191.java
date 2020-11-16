package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number191 {

    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0){
            ++num;
            n &= n-1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Number191().hammingWeight(11));
    }
}
