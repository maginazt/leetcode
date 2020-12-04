package com.maginazt.page14;

import com.maginazt.util.InputUtil;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/30 16:40
 */
public class Number1314 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] sum = buildSum(mat);
        int[][] result = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            int[] row = new int[mat[i].length];
            result[i] = row;
            for (int j = 0; j < row.length; j++) {
                int il = Math.max(0, i - K);
                int ih = Math.min(mat.length - 1, i + K);
                int jl = Math.max(0, j - K);
                int jh = Math.min(row.length - 1, j + K);
                result[i][j] = sum[ih][jh] - getNum(sum, il - 1, jh) - getNum(sum, ih, jl - 1) + getNum(sum, il - 1, jl - 1);
            }
        }
        return result;
    }

    private int[][] buildSum(int[][] mat) {
        int[][] sum = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            int[] row = new int[mat[i].length];
            sum[i] = row;
            for (int j = 0; j < row.length; j++) {
                sum[i][j] = getNum(sum, i - 1, j) + getNum(sum, i, j - 1) + mat[i][j] - getNum(sum, i - 1, j - 1);
            }
        }
        return sum;
    }

    private int getNum(int[][] mat, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return mat[i][j];
    }

    public static void main(String[] args) {
        Number1314 number1314 = new Number1314();
        System.out.println(Arrays.toString(number1314.matrixBlockSum(InputUtil.readIntArray("[[1,2,3],[4,5,6],[7,8,9]]"), 1)));
        System.out.println(Arrays.toString(number1314.matrixBlockSum(InputUtil.readIntArray("[[1,2,3],[4,5,6],[7,8,9]]"), 2)));
    }
}
