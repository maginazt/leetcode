package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number162 {

    public int findPeakElement(int[] nums) {
        if(nums.length < 2)
            return 0;
        int low = 0;
        int high = nums.length-1;
        int result = low;
        while (low <= high){
            int mid = (low+high)/2;
            boolean isGreaterThanLeft = mid == 0 || nums[mid] > nums[mid-1];
            boolean isGreaterThanRight = mid == nums.length-1 || nums[mid] > nums[mid+1];
            if(isGreaterThanLeft && isGreaterThanRight){
                result = mid;
                break;
            }
            else if(isGreaterThanLeft)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number162().findPeakElement(new int[]{1,2}));
    }
}
