package com.maginazt.other;

import java.util.Arrays;

/**
 * @author zhaotao
 * @date 2018/2/5
 */
public class EditDistance {

    public int distance(String str1, String str2) {
        int len1 = length(str1);
        int len2 = length(str2);
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        int[][] cache = new int[len1 + 1][len2 + 1];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return getDistance(str1.toCharArray(), 0, str2.toCharArray(), 0, cache);
    }

    private int getDistance(char[] src, int srcIdx, char[] dest, int destIdx, int[][] cache) {
        int result = cache[srcIdx][destIdx];
        if (result == -1) {
            if (srcIdx == src.length) {
                result = dest.length - destIdx;
            } else if (destIdx == dest.length) {
                result = src.length - srcIdx;
            } else {
                if (src[srcIdx] == dest[destIdx]) {
                    result = getDistance(src, srcIdx + 1, dest, destIdx + 1, cache);
                } else {
                    result = min(getDistance(src, srcIdx + 1, dest, destIdx + 1, cache),
                            getDistance(src, srcIdx, dest, destIdx + 1, cache),
                            getDistance(src, srcIdx + 1, dest, destIdx, cache)) + 1;
                }
            }
            cache[srcIdx][destIdx] = result;
        }
        return result;
    }

    private int length(String str) {
        return str == null ? 0 : str.length();
    }

    private int min(int a1, int a2, int a3) {
        return Math.min(a1, Math.min(a2, a3));
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.distance("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aabbbbbbbbbbbbbbbbbbbbasdfsadfewr"));
    }
}
