package com.maginazt.page6;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/24 14:09
 */
public class Number532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int i = 0;
        int j = i + 1;
        int prePair = Integer.MIN_VALUE;
        while (j < nums.length) {
            if (i == j || nums[j] < nums[i] + k) {
                ++j;
            } else if (nums[j] == nums[i] + k) {
                if (nums[i] != prePair) {
                    ++result;
                    prePair = nums[i];
                }
                ++i;
                ++j;
            } else {
                ++i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Number532 number532 = new Number532();
        Assert.assertEquals(4, number532.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        Assert.assertEquals(2, number532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        Assert.assertEquals(1, number532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        Assert.assertEquals(2, number532.findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3));
        Assert.assertEquals(2, number532.findPairs(new int[]{-1, -2, -3}, 1));
    }
}
