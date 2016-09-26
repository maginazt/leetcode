package com.maginazt.page3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/20.
 */
public class Number228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums != null && nums.length > 0){
            int rangeStart = nums[0];
            int rangeEnd = nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i] == rangeEnd + 1)
                    ++rangeEnd;
                else{
                    result.add(rangeStart == rangeEnd ? Integer.toString(rangeStart) : rangeStart+"->"+rangeEnd);
                    rangeStart = nums[i];
                    rangeEnd = nums[i];
                }
            }
            result.add(rangeStart == rangeEnd ? Integer.toString(rangeStart) : rangeStart+"->"+rangeEnd);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number228().summaryRanges(new int[]{0,1,2,4,5,7,99,100,101}));
    }
}
