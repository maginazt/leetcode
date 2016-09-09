package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/5.
 */
public class Number174 {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length < 1)
            return 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] minimumHps = new int[rows][cols];
        minimumHps[rows-1][cols-1] = dungeon[rows-1][cols-1] < 0 ? -dungeon[rows-1][cols-1]+1 : 0;
        //last row
        for(int col=cols-2;col>=0;col--){
            if(dungeon[rows-1][col] < 0)
                minimumHps[rows-1][col] = minimumHps[rows-1][col+1] == 0 ? -dungeon[rows-1][col]+1 : minimumHps[rows-1][col+1]-dungeon[rows-1][col];
            else
                minimumHps[rows-1][col] = Math.max(0, minimumHps[rows-1][col+1]-dungeon[rows-1][col]);
        }
        //last col
        for(int row=rows-2;row>=0;row--){
            if(dungeon[row][cols-1] < 0)
                minimumHps[row][cols-1] = minimumHps[row+1][cols-1] == 0 ? -dungeon[row][cols-1]+1 : minimumHps[row+1][cols-1]-dungeon[row][cols-1];
            else
                minimumHps[row][cols-1] = Math.max(0, minimumHps[row+1][cols-1]-dungeon[row][cols-1]);
        }
        for(int row=rows-2;row>=0;row--)
            for(int col=cols-2;col>=0;col--){
                //for right
                int a;
                //for down
                int b;
                if(dungeon[row][col] < 0){
                    a = minimumHps[row][col+1] == 0 ? -dungeon[row][col]+1 : minimumHps[row][col+1]-dungeon[row][col];
                    b = minimumHps[row+1][col] == 0 ? -dungeon[row][col]+1 : minimumHps[row+1][col]-dungeon[row][col];
                }
                else{
                    a = Math.max(0, minimumHps[row][col+1]-dungeon[row][col]);
                    b = Math.max(0, minimumHps[row+1][col]-dungeon[row][col]);
                }
                minimumHps[row][col] = Math.min(a, b);
            }
        return minimumHps[0][0] == 0 ? 1 : minimumHps[0][0];
    }

    public static void main(String[] args) {
//        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] dungeon = {{2},{1}};
        System.out.println(new Number174().calculateMinimumHP(dungeon));
    }
}
