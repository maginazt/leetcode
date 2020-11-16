package com.maginazt.page3;

/**
 * Created by zhaotao on 16/9/25.
 */
public class Number231 {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        return (n & (n-1)) == 0;
    }
}
