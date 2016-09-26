package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/18.
 */
public class Number223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        area -= crossRange(A, C, E, G) * crossRange(B, D, F, H);
        return area;
    }

    private int crossRange(int l1, int r1, int l2, int r2) {
        if(l1 > l2)
            return crossRange(l2, r2, l1, r1);
        if(l2 < r1)
            return Math.min(r1, r2) - l2;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number223().computeArea(-2,-2,2,2,-2,-2,2,2));
    }
}
