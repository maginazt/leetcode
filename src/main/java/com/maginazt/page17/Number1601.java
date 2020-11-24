package com.maginazt.page17;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/20 16:11
 */
public class Number1601 {

    public int maximumRequests(int n, int[][] requests) {
        int[] vector = new int[n];
        int bitmap = 1;
        int max = 1 << requests.length;
        int maximumSize = 0;
        while (bitmap < max) {
            int size = adjustVector(vector, requests, bitmap);
            if (isZero(vector) && size > maximumSize) {
                maximumSize = size;
            }
            ++bitmap;
        }
        return maximumSize;
    }

    private int adjustVector(int[] vector, int[][] requests, int bitmap) {
        int size = 0;
        for (int i = 0; i < requests.length; i++) {
            if (!isSet(bitmap, i)) {
                continue;
            }
            ++size;
            --vector[requests[i][0]];
            ++vector[requests[i][1]];
        }
        return size;
    }

    private boolean isSet(int bitmap, int i) {
        return (bitmap & (1 << i)) != 0;
    }

    private boolean isZero(int[] vector) {
        boolean isZero = true;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != 0) {
                isZero = false;
                vector[i] = 0;
            }
        }
        return isZero;
    }

    public static void main(String[] args) {
        Number1601 number1601 = new Number1601();
        Assert.assertEquals(5, number1601.maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
        Assert.assertEquals(3, number1601.maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}));
        Assert.assertEquals(4, number1601.maximumRequests(4, new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}));
    }
}
