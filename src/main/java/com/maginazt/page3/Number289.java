package com.maginazt.page3;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/10/9.
 */
public class Number289 {

    private static final int LIVE = 1;
    private static final int DEAD = 0;

    public void gameOfLife(int[][] board) {
        if(board != null && board.length > 0){
            int rows = board.length;
            int cols = board[0].length;
            int[] cachedRow = new int[cols];
            int[] prevRow = new int[cols];
            for(int row=0;row<rows;row++){
                System.arraycopy(board[row], 0, cachedRow, 0, cols);
                for(int col=0;col<cols;col++){
                    int neighbors = getNeighbors(board, row, col, prevRow, cachedRow);
                    if(board[row][col] == LIVE){
                        if(neighbors < 2 || neighbors > 3)
                            board[row][col] = DEAD;
                    }
                    else{
                        if(neighbors == 3)
                            board[row][col] = LIVE;
                    }
                }
                int[] tmp = cachedRow;
                cachedRow = prevRow;
                prevRow = tmp;
            }
        }
    }

    private int getNeighbors(int[][] board, int row, int col, int[] prevRow, int[] cachedRow) {
        int result = 0;
        if(row > 0){
            if(col > 0)
                result += prevRow[col-1];
            result += prevRow[col];
            if(col < board[0].length-1)
                result += prevRow[col+1];
        }
        if(col > 0)
            result += cachedRow[col-1];
        if(col < board[0].length-1)
            result += cachedRow[col+1];
        if(row < board.length-1){
            if(col > 0)
                result += board[row+1][col-1];
            result += board[row+1][col];
            if(col < board[0].length-1)
                result += board[row+1][col+1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        new Number289().gameOfLife(board);
        for(int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
