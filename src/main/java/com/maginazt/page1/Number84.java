package com.maginazt.page1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/3.
 */
public class Number84 {

    public int largestRectangleArea(int[] heights) {
        if(heights.length < 1)
            return 0;
        if(heights.length == 1)
            return heights[0];
        int maxAreaStartIndex = 0;
        int maxAreaEndIndex = 0;
        int maxArea = heights[0];
        List<Integer> areas = new ArrayList<>();
        for(int i=1;i<heights.length;i++){
            //adjacent
            if(maxAreaEndIndex + 1 == i){
                for(int j=maxAreaStartIndex;j<=i;j++){
                    int subArea = subArea(heights, j, i);
                    if(subArea >= maxArea){
                        maxAreaStartIndex = Math.min(maxAreaStartIndex, j);
                        maxAreaEndIndex = i;
                        maxArea = subArea;
                    }
                }

            }
            else{
                areas.add(maxArea);
                maxAreaStartIndex = i;
                maxAreaEndIndex = i;
                maxArea = heights[i];
            }
        }
        areas.add(maxArea);
        return Collections.max(areas);
    }

    private int subArea(int[] heights, int start, int end) {
        int min = heights[start];
        for(int i=start+1;i<=end;i++){
            if(heights[i] < min)
                min = heights[i];
        }
        return min * (end - start + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Number84().largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
