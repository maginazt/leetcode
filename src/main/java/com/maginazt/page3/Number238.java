package com.maginazt.page3;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/9/28.
 */
public class Number238 {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] rightHalf = new int[output.length];
        int[] leftHalf = new int[output.length];
        rightHalf[0] = 1;
        leftHalf[leftHalf.length-1] = 1;
        for(int rIndex=1;rIndex<nums.length;rIndex++){
            int lIndex = nums.length - rIndex - 1;
            rightHalf[rIndex] = rightHalf[rIndex-1] * nums[rIndex-1];
            leftHalf[lIndex] = leftHalf[lIndex+1] * nums[lIndex+1];
        }
        for(int i=0;i<output.length;i++)
            output[i] = rightHalf[i] * leftHalf[i];
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Number238().productExceptSelf(new int[]{1,2,3,4,0})));
    }
}
