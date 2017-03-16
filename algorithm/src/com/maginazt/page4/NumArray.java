package com.maginazt.page4;

/**
 * Created by zhaotao on 2016/10/12.
 */
public class NumArray {

    private int[] nums;
    private long[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new long[nums.length];
        for(int i=nums.length-1;i>=0;i--)
            sums[i] = sums[i] + nums[i] + (i==nums.length-1 ? 0L : sums[i+1]);
    }

    public int sumRange(int i, int j) {
        return (int)(sums[i]-sums[j]+nums[j]);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,5));
    }
}
