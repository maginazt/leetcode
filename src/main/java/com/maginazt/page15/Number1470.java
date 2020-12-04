package com.maginazt.page15;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/2 14:03
 */
public class Number1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int idx1 = 0;
        int idx2 = n;
        int index = 0;
        while (idx1 < n) {
            result[index++] = nums[idx1++];
            result[index++] = nums[idx2++];
        }
        return result;
    }

    public static void main(String[] args) {
        Number1470 number1470 = new Number1470();
        System.out.println(Arrays.toString(number1470.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(number1470.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(number1470.shuffle(new int[]{1, 2, 1, 2}, 2)));
    }
}
