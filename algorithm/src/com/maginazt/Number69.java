package com.maginazt;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Number69 {

    private static final int MAXNUM = 46341;

    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        if(x == 1)
            return 1;
        return findSqrt(x);
    }

    private int findSqrt(int x) {
        int low = 1;
        int high = MAXNUM;
        while(low < high){
            int mid = (high+low) >> 1;
            int product = mid * mid;
            if(product == x)
                return mid;
            else if(product > x)
                high = mid;
            else
                low = mid + 1;
        }
        return low-1;
    }

    public static void main(String[] args) {
        System.out.println(new Number69().mySqrt(46340*46339));
    }
}
