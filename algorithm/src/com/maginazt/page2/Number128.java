package com.maginazt.page2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/23.
 */
public class Number128 {

    private static final Map<Integer, Integer> num2Index = new HashMap<>();
    private static int[] parents;
    private static int[] sizes;

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        int longest = 1;
        parents = new int[nums.length];
        sizes = new int[nums.length];
        for (int i = 0;i<parents.length;i++){
            parents[i] = i;
            sizes[i] = 1;
        }
        num2Index.clear();
        num2Index.put(nums[0], 0);
        for(int i=1;i<nums.length;i++){
            //ignore the duplicates
            if(!num2Index.containsKey(nums[i])){
                //first try to merge the left
                int p = i;
                if(num2Index.containsKey(nums[i]-1))
                    p = union(i, num2Index.get(nums[i]-1));
                //then try to merge the right
                if(num2Index.containsKey(nums[i]+1))
                    p = union(p, num2Index.get(nums[i]+1));
                if(sizes[p] > longest)
                    longest = sizes[p];
                num2Index.put(nums[i], i);
            }
        }
        return longest;
    }

    private int union(int p1, int i2){
        int p2 = i2;
        while (parents[p2] != p2)
            p2 = parents[p2];
        if(sizes[p1] < sizes[p2]){
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
            return p2;
        }
        else{
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
            return p1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number128().longestConsecutive(new int[]{100,4,200,1,1,4,2}));
    }
}
