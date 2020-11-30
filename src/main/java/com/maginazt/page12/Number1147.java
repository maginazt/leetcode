package com.maginazt.page12;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/24 10:03
 */
public class Number1147 {

    public int longestDecomposition(String text) {
        return longestDecomposition(text, 0, text.length() - 1);
    }

    private int longestDecomposition(String text, int begin, int end) {
        if (begin == end) {
            return 1;
        }
        if (begin > end) {
            return 0;
        }
        int i = begin;
        int mid = (begin + end) / 2;
        while (i <= mid) {
            int j = begin + end - i;
            if (i == j) {
                break;
            }
            if (isEqual(text, begin, i, j)) {
                return 2 + longestDecomposition(text, i + 1, j - 1);
            }
            ++i;
        }
        return 1;
    }

    private boolean isEqual(String text, int begin1, int end1, int begin2) {
        int i = begin1;
        int j = begin2;
        while (i <= end1) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            ++i;
            ++j;
        }
        return true;
    }

    public static void main(String[] args) {
        Number1147 number1147 = new Number1147();
        Assert.assertEquals(7, number1147.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        Assert.assertEquals(1, number1147.longestDecomposition("merchant"));
        Assert.assertEquals(11, number1147.longestDecomposition("antaprezatepzapreanta"));
        Assert.assertEquals(3, number1147.longestDecomposition("aaa"));
    }
}
