package com.maginazt.page4;

/**
 * Created by zhaotao on 2016/10/12.
 */
public class Number300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length < 2)
            return nums.length;
        int max = 0;
        int[] lengthSoFar = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int maxLength = 1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] < nums[j]){
                    int length = lengthSoFar[j] + 1;
                    if(length > maxLength)
                        maxLength = length;
                }
            }
            lengthSoFar[i] = maxLength;
            if(maxLength > max)
                max = maxLength;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Number300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
