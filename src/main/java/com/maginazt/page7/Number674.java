package com.maginazt.page7;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/25 17:22
 */
public class Number674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int result = 0;
        int currentLength = 1;
        int index = 1;
        while (index < nums.length) {
            if (nums[index] > nums[index - 1]) {
                ++currentLength;
            } else {
                if (currentLength > result) {
                    result = currentLength;
                }
                currentLength = 1;
            }
            ++index;
        }
        if (currentLength > result) {
            result = currentLength;
        }
        return result;
    }

    public static void main(String[] args) {
        Number674 number674 = new Number674();
        Assert.assertEquals(2, number674.findLengthOfLCIS(new int[]{2, 1, 3}));
        Assert.assertEquals(4, number674.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        Assert.assertEquals(3, number674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        Assert.assertEquals(1, number674.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }
}
