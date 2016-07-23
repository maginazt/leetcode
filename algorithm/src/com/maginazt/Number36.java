package com.maginazt;

import java.util.Arrays;

/**
 * Created by zhaotao on 16/7/23.
 */
public class Number36 {

    public boolean isValidSudoku(char[][] board) {
        boolean[] occured = new boolean[10];
        //first check rows
        for(int row = 0;row<9;row++){
            Arrays.fill(occured, false);
            for(int col=0;col<9;col++){
                char num = board[row][col];
                if(num != '.'){
                    if(!occured[num-'0'])
                        occured[num-'0'] = true;
                    else
                        return false;
                }
            }
        }
        //then check cols
        for(int col=0;col<9;col++){
            Arrays.fill(occured, false);
            for(int row=0;row<9;row++){
                char num = board[row][col];
                if(num != '.'){
                    if(!occured[num-'0'])
                        occured[num-'0'] = true;
                    else
                        return false;
                }
            }
        }
        //finally check blocks
        for(int bigRow=0;bigRow<9;bigRow+=3)
            for(int bigCol=0;bigCol<9;bigCol+=3){
                Arrays.fill(occured, false);
                for(int row=bigRow;row<3+bigRow;row++)
                    for(int col=bigCol;col<3+bigCol;col++){
                        char num = board[row][col];
                        if(num != '.'){
                            if(!occured[num-'0'])
                                occured[num-'0'] = true;
                            else
                                return false;
                        }
                    }
            }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number36().isValidSudoku(new char[][]{".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()}));
    }
}
