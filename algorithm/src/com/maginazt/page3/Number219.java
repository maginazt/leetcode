package com.maginazt.page3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/9/18.
 */
public class Number219 {

    private static final Map<Integer, Integer> indexMap = new HashMap<>();

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums != null && nums.length > 1 && k > 0){
            indexMap.clear();
            for(int i=0;i<nums.length;i++){
                Integer key = nums[i];
                if(!indexMap.containsKey(key))
                    indexMap.put(key, i);
                else{
                    if(i-indexMap.get(key) <= k)
                        return true;
                    else
                        indexMap.put(key, i);
                }
            }
        }
        return false;
    }
}
