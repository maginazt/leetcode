package com.maginazt.page3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaotao on 2016/9/12.
 */
public class Number217 {

    private static final Set<Integer> set = new HashSet<>();

    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        set.clear();
        for(int i=0;i<nums.length;i++){
            Integer n = nums[i];
            if(set.contains(n))
                return true;
            set.add(n);
        }
        return result;
    }
}
