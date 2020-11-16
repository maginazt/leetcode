package com.maginazt.page2;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number164 {

    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        if(nums.length == 2)
            return Math.abs(nums[0]-nums[1]);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] < min)
                min = nums[i];
        }
        if(max == min)
            return 0;
        int maxGap = 0;
        //try to solve it linerly using bucket sort
        int avgGap = (max - min)/(nums.length-1)+1;
        //buckets: [min, min+avgGap), [min+avgGap, min+2*avgGap), ..., [min+(n-1)avgGap, max)
        //max is not in the last bucket
        int[] bucketMins = new int[nums.length-1];
        int[] bucketMaxs = new int[nums.length-1];
        Arrays.fill(bucketMins, Integer.MAX_VALUE);
        Arrays.fill(bucketMaxs, Integer.MIN_VALUE);
        for(int i=0;i<nums.length;i++){
            int bucketIndex = (nums[i] - min) / avgGap;
            if(bucketIndex < nums.length-1){
                if(nums[i] > bucketMaxs[bucketIndex])
                    bucketMaxs[bucketIndex] = nums[i];
                if(nums[i] < bucketMins[bucketIndex])
                    bucketMins[bucketIndex] = nums[i];
            }
        }
        int prev = -1;
        for(int i=0;i<bucketMaxs.length;i++){
            if(bucketMaxs[i] >= 0){
                if(prev >= 0){
                    maxGap = Math.max(maxGap, bucketMins[i]-prev);
                }
                prev = bucketMaxs[i];
            }
        }
        return Math.max(maxGap, max-prev);
    }

    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\test.txt"));
//        String input = br.readLine();
//        String[] numstrs = input.split(",");
//        int[] nums = new int[numstrs.length];
//        for(int i=0;i<numstrs.length;i++)
//            nums[i] = Integer.parseInt(numstrs[i]);
        System.out.println(new Number164().maximumGap(new int[]{1,10000000}));
    }
}
