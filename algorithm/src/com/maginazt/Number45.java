package com.maginazt;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Number45 {

    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int[] minSteps = new int[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            int step = 1;
            int maxStep = Math.min(nums[i], nums.length-i-1);
            if(maxStep == 0)
                minSteps[i] = Integer.MAX_VALUE;
            else{
                int minJump = Integer.MAX_VALUE;
                while(step <= maxStep){
                    if(minSteps[i+step] != Integer.MAX_VALUE && minSteps[i+step]+1 < minJump)
                        minJump = minSteps[i+step]+1;
                    ++step;
                }
                minSteps[i] = minJump;
            }
        }
        return minSteps[0];
    }

    public static void main(String[] args) {
        System.out.println(new Number45().jump(new int[]{2,3,0,0,4}));
    }
}
