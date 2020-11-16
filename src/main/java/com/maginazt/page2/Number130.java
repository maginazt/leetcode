package com.maginazt.page2;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/8/25.
 */
public class Number130 {

    private static boolean[][] isVisited;
    private static boolean[][] isNotCaptured;

    private static final LinkedList<Integer> queue4Row = new LinkedList<>();
    private static final LinkedList<Integer> queue4Col = new LinkedList<>();

    public void solve(char[][] board) {
        if(board != null && board.length > 1){
            int rows = board.length;
            int cols = board[0].length;
            isVisited = new boolean[rows][cols];
            isNotCaptured = new boolean[rows][cols];
            queue4Row.clear();
            queue4Col.clear();
            for(int i=0;i<cols-1;i++)
                if(board[0][i] == 'O'){
                    queue4Row.addLast(0);
                    queue4Col.addLast(i);
                }
            for(int i=0;i<rows-1;i++)
                if(board[i][cols-1] == 'O'){
                    queue4Row.addLast(i);
                    queue4Col.addLast(cols-1);
                }
            for(int i=cols-1;i>0;i--)
                if(board[rows-1][i] == 'O'){
                    queue4Row.addLast(rows-1);
                    queue4Col.addLast(i);
                }
            for(int i=rows-1;i>0;i--)
                if(board[i][0] == 'O'){
                    queue4Row.addLast(i);
                    queue4Col.addLast(0);
                }
            while (!queue4Row.isEmpty()){
                int row = queue4Row.removeFirst();
                int col = queue4Col.removeFirst();
                if(!isVisited[row][col]){
                    isVisited[row][col] = true;
                    isNotCaptured[row][col] = true;
                    //up
                    if(row > 0 && board[row-1][col] == 'O' && !isVisited[row-1][col]){
                        queue4Row.add(row-1);
                        queue4Col.add(col);
                    }
                    //down
                    if(row < board.length-1 && board[row+1][col] == 'O' && !isVisited[row+1][col]){
                        queue4Row.add(row+1);
                        queue4Col.add(col);
                    }
                    //left
                    if(col > 0 && board[row][col-1] == 'O' && !isVisited[row][col-1]){
                        queue4Row.add(row);
                        queue4Col.add(col-1);
                    }
                    //right
                    if(col < board[0].length-1 && board[row][col+1] == 'O' && !isVisited[row][col+1]){
                        queue4Row.add(row);
                        queue4Col.add(col+1);
                    }
                }
            }
            for(int row=0;row<rows;row++)
                for(int col=0;col<cols;col++){
                    if(board[row][col] == 'O' && !isNotCaptured[row][col])
                        board[row][col] = 'X';
                }
        }
    }

    public static void main(String[] args) {
//        char[][] board = {{'O','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'O'}};
        new Number130().solve(board);
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }
}
