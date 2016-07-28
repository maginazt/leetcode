package com.maginazt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Number54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length > 0){
            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            int colStart = 0;
            int colEnd = matrix[0].length - 1;
            while (rowStart <= rowEnd && colStart <= colEnd){
                //single row
                if(rowStart == rowEnd){
                    for(int col=colStart;col<=colEnd;col++)
                        result.add(matrix[rowStart][col]);
                    break;
                }
                //single col
                if(colStart == colEnd){
                    for(int row=rowStart;row<=rowEnd;row++)
                        result.add(matrix[row][colStart]);
                    break;
                }
                //1.top side
                for(int col=colStart;col<colEnd;col++)
                    result.add(matrix[rowStart][col]);
                //2.right side
                for(int row=rowStart;row<rowEnd;row++)
                    result.add(matrix[row][colEnd]);
                //3.down side
                for(int col=colEnd;col>colStart;col--)
                    result.add(matrix[rowEnd][col]);
                //left side
                for(int row=rowEnd;row>rowStart;row--)
                    result.add(matrix[row][colStart]);
                ++rowStart;
                --rowEnd;
                ++colStart;
                --colEnd;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number54().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
    }
}
