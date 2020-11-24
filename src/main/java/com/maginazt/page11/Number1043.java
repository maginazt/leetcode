package com.maginazt.page11;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/23 15:50
 */
public class Number1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] sums = new int[arr.length];
        int maxSum = -1;
        for (int i = 0; i < k; i++) {
            if (arr[i] > maxSum) {
                maxSum = arr[i];
            }
            sums[i] = maxSum * (i + 1);
        }
        for (int i = k; i < arr.length; i++) {
            int subMax = -1;
            for (int j = 0; j < k; j++) {
                if (arr[i - j] > subMax) {
                    subMax = arr[i - j];
                }
                int sum = sums[i - j - 1] + subMax * (j + 1);
                if (sum > sums[i]) {
                    sums[i] = sum;
                }
            }
        }
        return sums[arr.length - 1];
    }

    public static void main(String[] args) {
        Number1043 number1043 = new Number1043();
        Assert.assertEquals(84, number1043.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        Assert.assertEquals(83, number1043.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        Assert.assertEquals(1, number1043.maxSumAfterPartitioning(new int[]{1}, 1));
    }
}
