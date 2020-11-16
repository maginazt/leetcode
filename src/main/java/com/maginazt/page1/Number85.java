package com.maginazt.page1;

/**
 * Created by zhaotao on 16/8/13.
 */
public class Number85 {

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int[][] maxNumInRow = new int[maxRow][maxCol];
        int[][] maxNumInCol = new int[maxRow][maxCol];
        int result = 0;
        for(int row=0;row<maxRow;row++){
            for(int col=0;col<maxCol;col++){
                if(matrix[row][col] == '1'){
                    maxNumInCol[row][col] = col == 0 ? 1 : maxNumInCol[row][col-1] + 1;
                    maxNumInRow[row][col] = row == 0 ? 1 : maxNumInRow[row-1][col] + 1;
                    int subMax = Math.max(maxNumInRow[row][col], maxNumInCol[row][col]);
                    int minSpanRow = col == 0 ? maxNumInRow[row][col] : Math.min(maxNumInRow[row][col], maxNumInRow[row][col-1]);
                    int minSpanCol = row == 0 ? maxNumInCol[row][col] : Math.min(maxNumInCol[row][col], maxNumInCol[row-1][col]);
                    System.out.print("("+maxNumInRow[row][col]+","+maxNumInCol[row][col]+")");
                    subMax = Math.max(subMax, minSpanRow * minSpanCol);
                    if(subMax > result)
                        result = subMax;
                }
                else{
                    System.out.print("(0,0)");
                }

            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
//        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Number85().maximalRectangle(matrix));
    }
}
