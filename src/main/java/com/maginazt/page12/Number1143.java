package com.maginazt.page12;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/12/2 11:04
 */
public class Number1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] mat = new int[text1.length()][text2.length()];
        mat[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                mat[i][0] = 1;
            } else {
                mat[i][0] = Math.max(mat[i - 1][0], 0);
            }
        }
        for (int j = 1; j < text2.length(); j++) {
            if (text2.charAt(j) == text1.charAt(0)) {
                mat[0][j] = 1;
            } else mat[0][j] = Math.max(mat[0][j - 1], 0);
        }
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                int len = mat[i - 1][j - 1];
                if (text1.charAt(i) == text2.charAt(j)) {
                    len = 1 + mat[i - 1][j - 1];
                }
                if (mat[i - 1][j] > len) {
                    len = mat[i - 1][j];
                }
                if (mat[i][j - 1] > len) {
                    len = mat[i][j - 1];
                }
                mat[i][j] = len;
            }
        }
        return mat[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        Number1143 number1143 = new Number1143();
        Assert.assertEquals(3, number1143.longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(46, number1143.longestCommonSubsequence("dcbaddabcaadabacbbbddccbbccdbadbdaccdccbbbdbddcbacbdbcdcaddbdadabcbaacbaaaaadbcba", "adbcbccdcadcbcbcbbdccbddcdccababccbccbddbbbcabdbdacdbccccbabacaa"));
    }
}
