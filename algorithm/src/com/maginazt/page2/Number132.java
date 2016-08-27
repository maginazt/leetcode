package com.maginazt.page2;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/8/26.
 */
public class Number132 {

    private static boolean[][] isP;

    public int minCut(String s) {
        if(s != null && s.length() > 1){
            int[] cache = new int[s.length()];
            Arrays.fill(cache, -1);
            fillIsP(s);
            return minCut(s, 0, cache);
        }
        else
            return 0;
    }

    private void fillIsP(String s) {
        int length = s.length();
        isP = new boolean[length][length];
        for(int i=0;i<length;i++)
            for(int j=i;j<length;j++){
                int row = j - i;
                int col = j;
                if(row == col)
                    isP[row][col] = true;
                else
                    isP[row][col] = s.charAt(row) == s.charAt(col) ? (row+1 > col-1 ? true : isP[row+1][col-1]) : false;
            }
    }

    private int minCut(String s, int startIndex, int[] cache) {
        if(cache[startIndex] >= 0)
            return cache[startIndex];
        int minCut = Integer.MAX_VALUE;
        if(isP[startIndex][s.length()-1])
            minCut = 0;
        else{
            for(int end=startIndex;end<s.length()-1;end++) {
                if (isP[startIndex][end]) {
                    int cuts = 1 + minCut(s, end+1, cache);
                    if(cuts < minCut)
                        minCut = cuts;
                }
            }
        }
        cache[startIndex] = minCut;
        return minCut;
    }

    public static void main(String[] args) {
        Number132 number132 = new Number132();
        long start = System.currentTimeMillis();
        System.out.println(number132.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println("time: "+(System.currentTimeMillis()-start));
    }
}
