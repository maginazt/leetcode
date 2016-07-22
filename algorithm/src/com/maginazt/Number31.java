package com.maginazt;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/22.
 */
public class Number31 {

    public void nextPermutation(int[] nums) {
        if(nums!=null && nums.length>1){
            int nextNumber2Exchange = nums.length-2;
            //find the first number that less than its right side
            while(nextNumber2Exchange >= 0 && nums[nextNumber2Exchange] >= nums[nextNumber2Exchange+1])
                --nextNumber2Exchange;
            //the next permutation is not possible, just reverse the array
            if(nextNumber2Exchange < 0){
                reverse(nums, 0, nums.length-1);
                return;
            }
            //first reverse the right half
            reverse(nums, nextNumber2Exchange+1, nums.length-1);
            //find the first number that greater than nextNumber2Exchange
            int number2Exchange = nextNumber2Exchange+1;
            while (nums[number2Exchange] <= nums[nextNumber2Exchange])
                ++number2Exchange;
            //swap the two
            int tmp = nums[nextNumber2Exchange];
            nums[nextNumber2Exchange] = nums[number2Exchange];
            nums[number2Exchange] = tmp;
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        Number31 n = new Number31();
        int[] arr = {1,1,2,2};
        int[] loop = Arrays.copyOf(arr, arr.length);
        n.nextPermutation(loop);
        while(!Arrays.equals(arr, loop)){
            System.out.println(Arrays.toString(loop));
            n.nextPermutation(loop);
        }
    }
}
