package com.maginazt.page11;

/**
 * @author: zhaotao
 * @date: 2020/12/1 15:36
 */
public class Number1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        int[][][] mat = solveCommonSequence(str1, str2);
        char[] chars = new char[str1.length() + str2.length() - mat[str1.length() - 1][str2.length() - 1][0]];
        int index = chars.length - 1;
        int idx1 = str1.length() - 1;
        int idx2 = str2.length() - 1;
        int p1 = idx1;
        int p2 = idx2;
        while (p1 >= 0 && p2 >= 0) {
            int next1 = mat[p1][p2][1];
            int next2 = mat[p1][p2][2];
            if (p1 == next1 && p2 == next2) {
                if (mat[p1][p2][0] == 0) {
                    break;
                }
                while (idx1 > p1) {
                    chars[index--] = str1.charAt(idx1--);
                }
                while (idx2 > p2) {
                    chars[index--] = str2.charAt(idx2--);
                }
                chars[index--] = str1.charAt(p1);
                --p1;
                --p2;
                --idx1;
                --idx2;
            } else {
                p1 = next1;
                p2 = next2;
            }
        }
        while (idx1 >= 0) {
            chars[index--] = str1.charAt(idx1--);
        }
        while (idx2 >= 0) {
            chars[index--] = str2.charAt(idx2--);
        }
        return new String(chars);
    }

    private int[][][] solveCommonSequence(String str1, String str2) {
        int[][][] mat = new int[str1.length()][str2.length()][3];
        mat[0][0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        mat[0][0][1] = 0;
        mat[0][0][2] = 0;
        for (int i = 1; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                mat[i][0][0] = 1;
                mat[i][0][1] = i;
                mat[i][0][2] = 0;
            } else if (mat[i - 1][0][0] > 0) {
                mat[i][0][0] = mat[i - 1][0][0];
                mat[i][0][1] = i - 1;
                mat[i][0][2] = 0;
            } else {
                mat[i][0][0] = 0;
                mat[i][0][1] = i;
                mat[i][0][2] = 0;
            }
        }
        for (int j = 1; j < str2.length(); j++) {
            if (str2.charAt(j) == str1.charAt(0)) {
                mat[0][j][0] = 1;
                mat[0][j][1] = 0;
                mat[0][j][2] = j;
            } else if (mat[0][j - 1][0] > 0) {
                mat[0][j][0] = mat[0][j - 1][0];
                mat[0][j][1] = 0;
                mat[0][j][2] = j - 1;
            } else {
                mat[0][j][0] = 0;
                mat[0][j][1] = 0;
                mat[0][j][2] = j;
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                int len = mat[i - 1][j - 1][0];
                mat[i][j][1] = i - 1;
                mat[i][j][2] = j - 1;
                if (str1.charAt(i) == str2.charAt(j)) {
                    len = 1 + mat[i - 1][j - 1][0];
                    mat[i][j][1] = i;
                    mat[i][j][2] = j;
                }
                if (mat[i - 1][j][0] > len) {
                    len = mat[i - 1][j][0];
                    mat[i][j][1] = i - 1;
                    mat[i][j][2] = j;
                }
                if (mat[i][j - 1][0] > len) {
                    len = mat[i][j - 1][0];
                    mat[i][j][1] = i;
                    mat[i][j][2] = j - 1;
                }
                mat[i][j][0] = len;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Number1092 number1092 = new Number1092();
        System.out.println(number1092.shortestCommonSupersequence("dcbaddabcaadabacbbbddccbbccdbadbdaccdccbbbdbddcbacbdbcdcaddbdadabcbaacbaaaaadbcba", "adbcbccdcadcbcbcbbdccbddcdccababccbccbddbbbcabdbdacdbccccbabacaa"));
        System.out.println(number1092.shortestCommonSupersequence("bbabacaa", "cccababab"));
        System.out.println(number1092.shortestCommonSupersequence("abac", "cab"));
        System.out.println(number1092.shortestCommonSupersequence("adaeccb", "debacc"));
    }
}