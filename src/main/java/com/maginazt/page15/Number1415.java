package com.maginazt.page15;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/12/4 15:55
 */
public class Number1415 {

    public String getHappyString(int n, int k) {
        int total = 3 * (1 << n - 1);
        if (k > total) {
            return "";
        }
        char[] chars = new char[n];
        int index = k - 1;
        int base = total / 3;
        int offset = index / base;
        chars[0] = getChar(' ', offset);
        for (int i = 1; i < chars.length; i++) {
            index -= offset * base;
            base /= 2;
            offset = index / base;
            chars[i] = getChar(chars[i - 1], offset);
        }
        return new String(chars);
    }

    private char getChar(char prev, int offset) {
        for (char c = 'a'; c <= 'c'; c++) {
            if (c == prev) {
                continue;
            }
            if (offset == 0) {
                return c;
            }
            --offset;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Number1415 number1415 = new Number1415();
        Assert.assertEquals("c", number1415.getHappyString(1, 3));
        Assert.assertEquals("cab", number1415.getHappyString(3, 9));
        Assert.assertEquals("abacbabacb", number1415.getHappyString(10, 100));
    }
}
