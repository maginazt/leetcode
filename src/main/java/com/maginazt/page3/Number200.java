package com.maginazt.page3;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number200 {

//    public int numIslands(char[][] grid) {
//        int result = 0;
//        if(grid != null && grid.length > 0){
//            int rows = grid.length;
//            int cols = grid[0].length;
//            for(int row=0;row<rows;row++)
//                for(int col=0;col<cols;col++){
//                    if(grid[row][col] == '1' && (row == 0 || grid[row-1][col] != '1') && (col == 0 || grid[row][col-1] != '1')){
//                        ++result;
//                    }
//                    if(row > 0 && col > 0 && grid[row][col] == '1' && grid[row-1][col] == '1'){
//                        int left = col;
//                        while (left >0 && grid[row][left-1] == '1')
//                            --left;
//                        if(left != col && grid[row][left] == '1' && (row == 0 || grid[row-1][left] != '1') && (left == 0 || grid[row][left-1] != '1'))
//                            --result;
//                    }
//                }
//        }
//        return result;
//    }

    private static final LinkedList<Integer> queue4Row = new LinkedList<>();
    private static final LinkedList<Integer> queue4Col = new LinkedList<>();

    private boolean[][] isVisited;

    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid != null && grid.length > 0){
            queue4Row.clear();
            queue4Col.clear();
            int rows = grid.length;
            int cols = grid[0].length;
            isVisited = new boolean[rows][cols];
            for(int row=0;row<rows;row++)
                for(int col=0;col<cols;col++){
                    if(grid[row][col] == '1' && !isVisited[row][col]){
                        ++result;
                        isVisited[row][col] = true;
                        bfs(grid, row, col);
                    }
                }
        }
        return result;
    }

    private void bfs(char[][] grid, int row, int col) {
        queue4Row.add(row);
        queue4Col.add(col);
        while (!queue4Row.isEmpty()){
            int r = queue4Row.removeFirst();
            int c = queue4Col.removeFirst();
            if(r != 0 && grid[r-1][c] == '1' && !isVisited[r-1][c]){
                isVisited[r-1][c] = true;
                queue4Row.add(r-1);
                queue4Col.add(c);
            }
            if(r != grid.length-1 && grid[r+1][c] == '1' && !isVisited[r+1][c]){
                isVisited[r+1][c] = true;
                queue4Row.add(r+1);
                queue4Col.add(c);
            }
            if(c != 0 && grid[r][c-1] == '1' && !isVisited[r][c-1]){
                isVisited[r][c-1] = true;
                queue4Row.add(r);
                queue4Col.add(c-1);
            }
            if(c != grid[0].length-1 && grid[r][c+1] == '1' && !isVisited[r][c+1]){
                isVisited[r][c+1] = true;
                queue4Row.add(r);
                queue4Col.add(c+1);
            }
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
//        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        String[] grid = {"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
//        System.out.println(new Number200().numIslands(grid));
    }
}
