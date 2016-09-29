package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/29.
 */
public class Number239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 2)
            return nums;
        int[] result = new int[nums.length-k+1];
        int[] heap = new int[k];
        int[] indexInHeap = new int[nums.length];

        return result;
    }
}
