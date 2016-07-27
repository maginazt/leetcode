package com.maginazt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Number51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 1){
            List<String> solution = new ArrayList<>();
            solution.add("Q");
            result.add(solution);
        }
        else if(n > 1){
            boolean[][] occupied = new boolean[n][n];
            for(int i=0;i<n;i++){
                occupied[0][i] = true;
                solveNQueens(result, occupied, 1);
                occupied[0][i] = false;
            }
        }
        return result;
    }

    public void solveNQueens(List<List<String>> result, boolean[][] occupied, int layer){
        for(int i=0;i<occupied.length;i++){
            if(isValid(occupied, layer, i)){
                occupied[layer][i] = true;
                //find a solution
                if(layer == occupied.length-1){
                    addToResult(result, occupied);
                }
                else{
                    solveNQueens(result, occupied, layer+1);
                }
                occupied[layer][i] = false;
            }
        }
    }

    private void addToResult(List<List<String>> result, boolean[][] occupied) {
        List<String> solution = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int row=0;row<occupied.length;row++){
            sb.delete(0, sb.length());
            for(int col=0;col<occupied.length;col++)
                sb.append(occupied[row][col] ? 'Q' : '.');
            solution.add(sb.toString());
        }
        result.add(solution);
    }

    private boolean isValid(boolean[][] occupied, int row, int col) {
        //check top col
        for(int i=row-1;i>=0;i--)
            if(occupied[i][col])
                return false;
        //check top left
        int i = row-1;
        int j = col-1;
        while(i >=0 && j>=0){
            if(occupied[i][j])
                return false;
            --i;
            --j;
        }
        //check top right
        i = row-1;
        j = col+1;
        while(i >=0 && j <occupied.length){
            if(occupied[i][j])
                return false;
            --i;
            ++j;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number51().solveNQueens(5));
    }
}
