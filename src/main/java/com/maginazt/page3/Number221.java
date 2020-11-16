package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/18.
 */
public class Number221 {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] maximalSquare = new int[rows][cols];
        int maximal = matrix[rows-1][cols-1] == '1' ? 1 : 0;
        maximalSquare[rows-1][cols-1] = matrix[rows-1][cols-1] == '1' ? 1 : 0;
        for(int col=cols-2;col>=0;col--){
            if(matrix[rows-1][col] == '1'){
                maximalSquare[rows-1][col] = 1;
                maximal = 1;
            }
            else
                maximalSquare[rows-1][col] = 0;
        }
        for(int row=rows-2;row>=0;row--){
            if(matrix[row][cols-1] == '1'){
                maximalSquare[row][cols-1] = 1;
                maximal = 1;
            }
            else
                maximalSquare[row][cols-1] = 0;
        }
        for(int row=rows-2;row>=0;row--)
            for(int col=cols-2;col>=0;col--){
                if(matrix[row][col] == '0')
                    maximalSquare[row][col] = 0;
                else{
                    int m = Math.min(Math.min(maximalSquare[row+1][col], maximalSquare[row+1][col+1]), maximalSquare[row][col+1]) + 1;
                    maximalSquare[row][col] = m;
                    if(m > maximal)
                        maximal = m;
                }
            }
        return maximal * maximal;
    }

    public static void main(String[] args) {
        //"10100","10111","11111","10010"
        System.out.println(new Number221().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
