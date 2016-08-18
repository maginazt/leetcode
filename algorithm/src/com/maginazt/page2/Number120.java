package com.maginazt.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        int[] arr = new int[triangle.size()];
        for(int level=0;level<arr.length;level++){
            List<Integer> nums = triangle.get(level);
            for(int index=nums.size()-1;index>=0;index--){
                if(index == 0)
                    arr[index] += nums.get(index);
                else if(index == nums.size()-1)
                    arr[index] = arr[index-1] + nums.get(index);
                else
                    arr[index] = Math.min(arr[index-1], arr[index]) + nums.get(index);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
            if(arr[i] < min)
                min = arr[i];
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(new Number120().minimumTotal(triangle));
    }
}
