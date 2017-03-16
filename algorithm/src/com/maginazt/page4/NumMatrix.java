package com.maginazt.page4;

/**
 * Created by zhaotao on 2016/10/12.
 */
public class NumMatrix {

    private int[][] matrix;
    private long[][] sumRows;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length > 0){
            sumRows = new long[matrix.length][matrix[0].length];
            for(int row=0;row<matrix.length;row++){
                for(int col=matrix[row].length-1;col>=0;col--)
                    sumRows[row][col] = sumRows[row][col] + matrix[row][col] + (col==matrix[row].length-1 ? 0L : sumRows[row][col+1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int sum = 0;
        for(int row=row1;row<=row2;row++)
            sum += (int)(sumRows[row][col1]-sumRows[row][col2]+matrix[row][col2]);
        return sum;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
