package com.maginazt;

/**
 * Created by zhaotao on 16/7/31.
 */
public class Number79 {

    public boolean exist(char[][] board, String word) {
        if(word.length() < 1)
            return true;
        boolean[][] occupied = new boolean[board.length][board[0].length];
        for(int row=0;row<board.length;row++)
            for(int col=0;col<board[0].length;col++){
                if(board[row][col] == word.charAt(0)){
                    occupied[row][col] = true;
                    if(persuitNext(board, occupied, row, col, word, 1))
                        return true;
                    occupied[row][col] = false;
                }
            }
        return false;
    }

    private boolean persuitNext(char[][] board, boolean[][] occupied, int row, int col, String word, int index) {
        if(index < word.length()){
            char next = word.charAt(index);
            //go up
            if(row > 0 && !occupied[row-1][col] && board[row-1][col] == next){
                occupied[row-1][col] = true;
                if(persuitNext(board, occupied, row-1, col, word, index+1))
                    return true;
                occupied[row-1][col] = false;
            }
            //go right
            if(col < board[0].length-1 && !occupied[row][col+1] && board[row][col+1] == next){
                occupied[row][col+1] = true;
                if(persuitNext(board, occupied, row, col+1, word, index+1))
                    return true;
                occupied[row][col+1] = false;
            }
            //go down
            if(row < board.length-1 && !occupied[row+1][col] && board[row+1][col] == next){
                occupied[row+1][col] = true;
                if(persuitNext(board, occupied, row+1, col, word, index+1))
                    return true;
                occupied[row+1][col] = false;
            }
            //go left
            if(col > 0 && !occupied[row][col-1] && board[row][col-1] == next){
                occupied[row][col-1] = true;
                if(persuitNext(board, occupied, row, col-1, word, index+1))
                    return true;
                occupied[row][col-1] = false;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Number79().exist(board, "ABCB"));
    }
}
