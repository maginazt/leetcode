package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/31.
 */
public class Number152 {

    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i=1;i<nums.length;i++){
            int a = nums[i];
            int b = currentMax * a;
            int c = currentMin * a;
            currentMax = Math.max(Math.max(a, b), c);
            currentMin = Math.min(Math.min(a, b), c);
            if(currentMax > maxProduct)
                maxProduct = currentMax;
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new Number152().maxProduct(new int[]{2,3,-2,4}));
    }
}
