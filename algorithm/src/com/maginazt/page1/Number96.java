package com.maginazt.page1;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number96 {

    public int numTrees(int n) {
        if(n == 1)
            return 1;
        int[][] nums = new int[n+1][n+1];
        for(int j=n;j>=1;j--)
            for(int i=1;i<=j;i++){
                int row = i;
                int col = n-j+i;
                if(row == col)
                    nums[row][col] = 1;
                else{
                    nums[row][col] = nums[row+1][col] + nums[row][col-1];
                    for(int k=row+1;k<col;k++)
                        nums[row][col] += nums[row][k-1] * nums[k+1][col];
                }
            }
        return nums[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Number96().numTrees(10));
    }
}
