package com.maginazt.page3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/20.
 */
public class Number229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums != null && nums.length > 0){
            if(nums.length == 1){
                result.add(nums[0]);
            }
            else if(nums.length == 2){
                result.add(nums[0]);
                if(nums[1] != nums[0])
                    result.add(nums[1]);
            }
            else{
                int cand1 = nums[0];
                int appearNum1 = 1;
                int cand2 = 0;
                int appearNum2 = 0;
                for(int i=1;i<nums.length;i++){
                    if(nums[i] == cand1)
                        ++appearNum1;
                    else if(nums[i] == cand2)
                        ++appearNum2;
                    else if(appearNum1 == 0){
                        cand1 = nums[i];
                        appearNum1 = 1;
                    }
                    else if(appearNum2 == 0){
                        cand2 = nums[i];
                        appearNum2 = 1;
                    }
                    else{
                        --appearNum1;
                        --appearNum2;
                    }
                }
                appearNum1 = 0;
                appearNum2 = 0;
                for(int i=0;i<nums.length;i++){
                    if(nums[i] == cand1)
                        ++appearNum1;
                    else if(nums[i] == cand2)
                        ++appearNum2;
                }
                int limit = nums.length / 3;
                if(appearNum1 > limit)
                    result.add(cand1);
                if(appearNum2 > limit)
                    result.add(cand2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        [2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9]
//        1,1,1,3,3,2,2,2
//        [1,2,0,4,5,0,6,7,8,9,9,9,9,9,9,0,0,0,0,0]
//        [1,1,1,2,3,4,5,6]
        System.out.println(new Number229().majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
