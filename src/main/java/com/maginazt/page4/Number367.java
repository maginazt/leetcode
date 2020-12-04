package com.maginazt.page4;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/12/4 09:10
 */
public class Number367 {

    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Number367 number367 = new Number367();
        Assert.assertTrue(number367.isPerfectSquare(2147395600));
        Assert.assertTrue(number367.isPerfectSquare(1));
        Assert.assertTrue(number367.isPerfectSquare(81));
        Assert.assertFalse(number367.isPerfectSquare(Integer.MAX_VALUE));
    }
}
