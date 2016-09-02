package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number169 {

    public int majorityElement(int[] nums) {
        //using Moore's voting algorithm
        int theMajority = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == theMajority)
                ++count;
            else
                --count;
            if(count == 0){
                theMajority = nums[i];
                count = 1;
            }
        }
        return theMajority;
    }

    public static void main(String[] args) {
        System.out.println(new Number169().majorityElement(new int[]{1,2,3,2,1,2,1}));
    }
}
