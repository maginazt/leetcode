package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/31.
 */
public class Number153 {

    public int findMin(int[] nums) {
        if(nums.length < 2)
            return nums[0];
        int low = 0;
        int high = nums.length-1;
        int min = nums[low];
        while (nums[low] > nums[high]){
            int mid = (low+high)/2;
            if(nums[low] > nums[mid]){
                high = mid;
                continue;
            }
            int leftMin = nums[low];
            if(nums[mid+1] > nums[high]){
                low = mid+1;
                continue;
            }
            int rightMin = nums[mid+1];
            min = Math.min(leftMin, rightMin);
            break;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Number153().findMin(new int[]{1,2}));
    }
}
