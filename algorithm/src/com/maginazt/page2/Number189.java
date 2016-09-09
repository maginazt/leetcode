package com.maginazt.page2;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number189 {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1)
            return;
        k = k % nums.length;
        rotate(nums, 0, nums.length-k-1);
        rotate(nums, nums.length-k, nums.length-1);
        rotate(nums, 0, nums.length-1);
    }

    private void rotate(int[] nums, int start, int end){
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new Number189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
