package com.maginazt.page4;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/23 18:14
 */
public class Number342 {

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if ((n & (n - 1)) != 0) {
            return false;
        }
        int zeroCount = 0;
        for (int i = 0; i < 32; i++) {
            if (!isZero(n, i)) {
                break;
            }
            ++zeroCount;
        }
        return zeroCount > 0 && zeroCount % 2 == 0;
    }

    private boolean isZero(int bitmap, int i) {
        return (bitmap & (1 << i)) == 0;
    }

    public static void main(String[] args) {
        Number342 number342 = new Number342();
        Assert.assertTrue(number342.isPowerOfFour(16));
        Assert.assertFalse(number342.isPowerOfFour(5));
        Assert.assertFalse(number342.isPowerOfFour(Integer.MAX_VALUE));
        Assert.assertFalse(number342.isPowerOfFour(Integer.MIN_VALUE));
        Assert.assertFalse(number342.isPowerOfFour(12));
    }
}
