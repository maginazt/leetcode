package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/10/10.
 */
public class Number287 {

    public int findDuplicate(int[] nums) {
        int high = nums.length - 1;
        int low = 1;
        while (low < high){
            int mid = (low+high)/2;
            int count = count(nums, mid);
            if(count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private int count(int[] nums, int upper) {
        int count = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i] <= upper)
                ++count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Number287().findDuplicate(new int[]{1,1}));
    }
}
