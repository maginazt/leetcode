package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number201 {

    public int rangeBitwiseAnd(int m, int n) {
        if(m == n)
            return m;
        if(m < (0x1 << 30)){
            int offsets = 0;
            int p = m;
            while (p >0){
                ++offsets;
                p = p >> 1;
            }
            int border = 0x1 << offsets;
            if(n >= border)
                return 0;
        }
        int off = 0;
        while (m != n){
            ++off;
            m = m >> 1;
            n = n >> 1;
        }
        return m << off;
    }

    public static void main(String[] args) {
        System.out.println(new Number201().rangeBitwiseAnd(5,7));
    }
}
