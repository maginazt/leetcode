package com.maginazt;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Number50 {

    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(x == 1.0)
            return x;
        if(n < 0)
            return 1 / myPow(x, -n);
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if(n == 1)
            return x;
        double sub = pow(x, n/2);
        return sub * sub * (n % 2 == 1 ? x : 1);
    }

    public static void main(String[] args) {
        System.out.println(new Number50().myPow(3.3, 5));
    }
}
