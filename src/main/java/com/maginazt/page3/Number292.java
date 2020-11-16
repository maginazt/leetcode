package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/10/9.
 */
public class Number292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number292().canWinNim(100));
    }
}
