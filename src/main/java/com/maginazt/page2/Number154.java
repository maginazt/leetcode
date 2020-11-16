package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/31.
 */
public class Number154 {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    private int findMin(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];
        if(start == end - 1)
            return Math.min(nums[start], nums[end]);
        if(nums[start] < nums[end])
            return nums[start];
        int mid = (start+end)/2;
        if(nums[start] < nums[mid])
            return findMin(nums, mid+1, end);
        int minLeft = findMin(nums, start, mid);
        int minRight = findMin(nums, mid+1, end);
        return Math.min(minLeft, minRight);
    }

    public static void main(String[] args) {
        System.out.println(new Number154().findMin(new int[]{3,3,1,3}));
    }
}
