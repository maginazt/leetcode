package com.maginazt.page3;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhaotao on 2016/9/18.
 */
public class Number220 {

    private static final TreeMap<Integer, Integer> indexMap = new TreeMap<>();

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums != null && nums.length > 1 && k > 0 && t >= 0){
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
                Map<Integer, Integer> subMap = indexMap.subMap(key-t>key?Integer.MIN_VALUE:key-t, true, key+t<key?Integer.MAX_VALUE:key+t, true);
                for(Map.Entry<Integer, Integer> entry : subMap.entrySet()){
                    if(i!=entry.getValue() && i-entry.getValue() <= k)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        [0,2147483647]
//        1
//        2147483647
        System.out.println(new Number220().containsNearbyAlmostDuplicate(new int[]{-3,3}, 2,4));
    }
}
