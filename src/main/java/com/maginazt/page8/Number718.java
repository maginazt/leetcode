package com.maginazt.page8;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/12/1 10:32
 */
public class Number718 {

    public int findLength(int[] A, int[] B) {
        int result = 0;
        int[][] mat = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            mat[i][0] = A[i] == B[0] ? 1 : 0;
            if (mat[i][0] > result) {
                result = mat[i][0];
            }
        }
        for (int j = 0; j < B.length; j++) {
            mat[0][j] = A[0] == B[j] ? 1 : 0;
            if (mat[0][j] > result) {
                result = mat[0][j];
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                mat[i][j] = A[i] == B[j] ? 1 + mat[i - 1][j - 1] : 0;
                if (mat[i][j] > result) {
                    result = mat[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Number718 number718 = new Number718();
        Assert.assertEquals(3, number718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
