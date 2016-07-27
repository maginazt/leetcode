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
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        double sub = pow(x, n/2);
        double tail = 1;
        switch (n%2){
            case 1:
                tail = x;
                break;
            case -1:
                tail = 1 / x;
                break;
        }
        return sub * sub * tail;
    }

    public static void main(String[] args) {
        System.out.println(new Number50().myPow(34.00515, -3));
    }
}
