package com.maginazt.page1;

import java.util.*;

/**
 * Created by zhaotao on 16/7/24.
 */
public class Number39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates!=null && candidates.length>0){
            //sort & erase duplicate
            Set<Integer> set = new TreeSet<>();
            for(int i : candidates)
                set.add(i);
            int[] processed = new int[set.size()];
            int index = 0;
            for(Iterator<Integer> it=set.iterator();it.hasNext();index++){
                processed[index] = it.next();
            }
            process(processed, 0, target, result);
        }
        return result;
    }

    private void process(int[] nums, int beginIndex, int target, List<List<Integer>> result, int... others) {
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
            int[] newOthers = new int[others.length+1];
            System.arraycopy(others, 0, newOthers, 0, others.length);
            newOthers[others.length] = nums[beginIndex];
            process(nums, beginIndex, target-nums[beginIndex], result, newOthers);
            if(beginIndex < nums.length-1)
                process(nums, beginIndex+1, target, result, others);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
