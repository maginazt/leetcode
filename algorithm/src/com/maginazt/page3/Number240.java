package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/30.
 */
public class Number240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rIndex = 0;
        int cIndex = 0;
        int prevRIndex = 0;
        int prevCIndex = 0;
        boolean canGoRight = true;
        while (true) {
            if (matrix[rIndex][cIndex] == target)
                return true;
            else if (matrix[rIndex][cIndex] < target) {
                if (canGoRight) {
                    //try to go right
                    if (cIndex == cols - 1)
                        canGoRight = false;
                    else {
                        prevRIndex = rIndex;
                        prevCIndex = cIndex;
                        cIndex += 1;
                        continue;
                    }
                }
                //try to go down
                if (rIndex == rows - 1)
                    break;
                else {
                    prevRIndex = rIndex;
                    prevCIndex = cIndex;
                    rIndex += 1;
                }
            } else {
                if(canGoRight)
                    canGoRight = false;
                //backstrace
                if (prevRIndex == rIndex && prevCIndex <= cIndex) {
                    if (cIndex == 0 || rIndex == rows - 1)
                        break;
                    prevRIndex = rIndex;
                    prevCIndex = cIndex;
                    rIndex += 1;
                    cIndex -= 1;
                } else{
                    if (cIndex == 0)
                        break;
                    prevRIndex = rIndex;
                    prevCIndex = cIndex;
                    cIndex -= 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Number240().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 300));
    }
}
