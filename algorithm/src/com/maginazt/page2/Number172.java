package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/2.
 */
public class Number172 {

    public int trailingZeroes(int n) {
        if(n < 1)
            return 0;
        int result = 0;
        int fac = n;
        while (fac > 0){
            result += fac / 5;
            fac /= 5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number172().trailingZeroes(100));
    }
}
