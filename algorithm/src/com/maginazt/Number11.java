package com.maginazt;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Number11 {
    public int maxArea(int[] height) {
        if(height==null || height.length<2)
            return 0;
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int shortest = height[left] < height[right] ? height[left] : height[right];
            int area = shortest * (right - left);
            if(area > maxArea)
                maxArea = area;
            if(shortest == height[left])
                ++left;
            else
                --right;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Number11().maxArea(new int[]{1,1}));
    }
}
