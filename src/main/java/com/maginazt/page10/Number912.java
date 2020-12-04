package com.maginazt.page10;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/2 15:54
 */
public class Number912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int pivitol = partition(nums, begin, end);
            quickSort(nums, begin, pivitol - 1);
            quickSort(nums, pivitol + 1, end);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        int p = nums[end];
        int low = begin - 1;
        for (int i = begin; i < end; i++) {
            if (nums[i] < p) {
                ++low;
                int tmp = nums[low];
                nums[low] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[low + 1];
        nums[low + 1] = nums[end];
        nums[end] = tmp;
        return low + 1;
    }

    public static void main(String[] args) {
        Number912 number912 = new Number912();
        System.out.println(Arrays.toString(number912.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(number912.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
