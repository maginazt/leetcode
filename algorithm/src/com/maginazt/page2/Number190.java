package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number190 {

    public int reverseBits(int n) {
        int result = 0;
        for(int i=1;i<=16;i++){
            int bitHigh = (n & (1 << (32-i))) >>> (32-i);
            int bitLow = (n & (1 << (i-1))) >> (i-1);
            if(bitHigh == 1)
                result |= 1 << (i-1);
            if(bitLow == 1)
                result |= 1 << (32-i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number190().reverseBits(1));
    }
}
