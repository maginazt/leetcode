package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number198 {

    public int rob(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        int[] maximums = new int[nums.length+1];
        maximums[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
            maximums[i] = Math.max(nums[i]+maximums[i+2], maximums[i+1]);
        return maximums[0];
    }

    public static void main(String[] args) {
        System.out.println(new Number198().rob(new int[]{1,5,9,4,6,8}));
    }
}
