package com.maginazt.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 16/7/23.
 */
public class Number37 {

    public void solveSudoku(char[][] board) {
        List<Integer>[][] possibleInputs = new List[9][9];
        prepare(board, possibleInputs);
        solveSudoku(board, 0, 0, possibleInputs);
    }

    private boolean solveSudoku(char[][] board, int beginRow, int beginCol, List<Integer>[][] possibleInputs) {
        //find next blank
        int row = beginRow;
        int col = beginCol;
        outer:
        while(row<9){
            while(col<9){
                if(board[row][col] == '.')
                    break outer;
                ++col;
            }
            row += 1;
            col = 0;
        }
        //no more blanks, find the solution
        if(row >= 9)
            return true;
        //try to fill the blank
        //no possible input is available
        List<Integer> theInputs = possibleInputs[row][col];
        for(Integer nextNumber : theInputs){
            List<Integer> modified = new ArrayList<>();
            fill(board, row, col, nextNumber, possibleInputs, modified);
            if(solveSudoku(board, row, col, possibleInputs))
                return true;
            else
                unfill(board, row, col, nextNumber, possibleInputs, modified);
        }
        return false;
    }

    private void unfill(char[][] board, int row, int col, Integer nextNumber, List<Integer>[][] possibleInputs, List<Integer> modified) {
        board[row][col] = '.';
        for(int i=0;i<modified.size();i+=2){
            List<Integer> inputs = possibleInputs[modified.get(i)][modified.get(i+1)];
            if(!inputs.contains(nextNumber))
                inputs.add(nextNumber);
        }
    }

    private void fill(char[][] board, int row, int col, Integer nextNumber, List<Integer>[][] possibleInputs, List<Integer> modified) {
        board[row][col] = (char)(nextNumber+'0');
        //erase the row
        for(int i=col+1;i<9;i++)
            if(board[row][i] == '.' && possibleInputs[row][i].contains(nextNumber)){
                modified.add(row);
                modified.add(i);
                possibleInputs[row][i].remove(nextNumber);
            }
        //erase the col
        for(int i=row+1;i<9;i++)
            if(board[i][col] == '.' && possibleInputs[i][col].contains(nextNumber)){
                modified.add(i);
                modified.add(col);
                possibleInputs[i][col].remove(nextNumber);
            }
        //erase the unit
        int bigRow = (row/3)*3;
        int bigCol = (col/3)*3;
        int i = row;
        int j = col+1;
        while(i<bigRow+3){
            while(j<bigCol+3){
                if(board[i][j] == '.' && possibleInputs[i][j].contains(nextNumber)){
                    modified.add(i);
                    modified.add(j);
                    possibleInputs[i][j].remove(nextNumber);
                }
                j+=1;
            }
            i+=1;
            j=bigCol;
        }
    }

    private void prepare(char[][] board, List<Integer>[][] possibleInputs) {
        for(int row=0;row<9;row++)
            for(int col=0;col<9;col++){
                char num = board[row][col];
                if(num == '.')
                    determine(board, possibleInputs, row, col);
            }
    }

    private void determine(char[][] board, List<Integer>[][] possibleInputs, int row, int col) {
        List<Integer> inputs = new ArrayList<>();
        boolean[] occurs = new boolean[10];
        //check rows
        for(int i=0;i<9;i++){
            char num = board[row][i];
            if(num!='.')
                occurs[num-'0'] = true;
        }
        //check cols
        for(int i=0;i<9;i++){
            char num = board[i][col];
            if(num!='.')
                occurs[num-'0'] = true;
        }
        //check unit
        int bigRow = (row/3)*3;
        int bigCol = (col/3)*3;
        for(int i=bigRow;i<bigRow+3;i++)
            for(int j=bigCol;j<bigCol+3;j++){
                char num = board[i][j];
                if(num!='.')
                    occurs[num-'0'] = true;
            }
        for(int i=1;i<occurs.length;i++){
            if(!occurs[i])
                inputs.add(i);
        }
        possibleInputs[row][col] = inputs;
    }

    public static void main(String[] args) {
        char[][] board = {".....7..9".toCharArray(),".4..812..".toCharArray(),"...9...1.".toCharArray(),"..53...72".toCharArray(),"293....5.".toCharArray(),".....53..".toCharArray(),"8...23...".toCharArray(),"7...5..4.".toCharArray(),"531.7....".toCharArray()};
        new Number37().solveSudoku(board);
        print(board);
        System.out.println(new Number36().isValidSudoku(board));
    }

    private static void print(char[][] board) {
        System.out.println("================================");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                System.out.print((board[i][j]-'0')+"  ");
            System.out.println();
        }
    }
}
