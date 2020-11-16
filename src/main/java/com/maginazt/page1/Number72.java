package com.maginazt.page1;

/**
 * Created by zhaotao on 16/7/30.
 */
public class Number72 {

    public int minDistance(String word1, String word2) {
        if("".equals(word1) || "".equals(word2))
            return Math.max(word1.length(), word2.length());
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] minD = new int[len1+1][len2+1];
        minD[len1][len2] = 0;
        //fill the corner cases
        for(int row=len1-1;row>=0;row--)
            minD[row][len2] = len1 - row;
        for(int col=len2-1;col>=0;col--)
            minD[len1][col] = len2 - col;
        for(int row=len1-1;row>=0;row--)
            for(int col=len2-1;col>=0;col--){
                minD[row][col] = Math.min(1+minD[row+1][col], Math.min(1+minD[row][col+1], minD[row+1][col+1]+(word1.charAt(row) == word2.charAt(col) ? 0 : 1)));
            }
        return minD[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Number72().minDistance("ache", "chchad"));
    }
}
