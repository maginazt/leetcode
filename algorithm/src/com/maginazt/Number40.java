package com.maginazt;

import java.util.*;

/**
 * Created by zhaotao on 16/7/24.
 */
public class Number40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        if(candidates!=null && candidates.length>0){
            //sort
            Arrays.sort(candidates);
            process(candidates, 0, target, result);
        }
        return new ArrayList<>(result);
    }

    private void process(int[] nums, int beginIndex, int target, Set<List<Integer>> result, int... others) {
        //find a match
        if(nums[beginIndex] == target){
            List<Integer> match = new ArrayList<>();
            for(int i=0;i<others.length;i++)
                match.add(others[i]);
            match.add(nums[beginIndex]);
            result.add(match);
        }
        //recursively find
        else if(nums[beginIndex] < target){
            if(beginIndex < nums.length-1){
                int[] newOthers = new int[others.length+1];
                System.arraycopy(others, 0, newOthers, 0, others.length);
                newOthers[others.length] = nums[beginIndex];
                process(nums, beginIndex+1, target-nums[beginIndex], result, newOthers);
                process(nums, beginIndex+1, target, result, others);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
