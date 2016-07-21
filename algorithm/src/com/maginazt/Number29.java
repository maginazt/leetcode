package com.maginazt;

/**
 * Created by Administrator on 2016/7/21.
 */
public class Number29 {

    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        int sign = ((dividend >>> 31) ^ (divisor >>> 31)) == 0 ? 1 : -1;
        long dividendL = dividend;
        long divisorL = divisor;
        long result = sign * divideL(Math.abs(dividendL), Math.abs(divisorL));
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
    }

    /**
     * all positive numbers
     */
    private long divideL(long dividend, long divisor) {
        long result = 0;
        long remain = dividend;
        //use shift operators to kick out large numbers
        while(remain > divisor){
            int shiftNumber = 0;
            long largeDivisor = divisor;
            while(remain > (largeDivisor << 1)){
                largeDivisor = largeDivisor << 1;
                ++shiftNumber;
            }
            result += 1 << shiftNumber;
            remain -= largeDivisor;
        }
        if(remain == divisor)
            result += 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number29().divide(-90, 3));
    }
}
