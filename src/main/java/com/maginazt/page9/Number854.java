package com.maginazt.page9;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaotao
 * @date: 2020/12/1 14:37
 */
public class Number854 {

    public int kSimilarity(String A, String B) {
        Map<String, Integer> cache = new HashMap<>();
        return kSimilarity(A, B, cache, A.length() - 1);
    }

    private int kSimilarity(String a, String b, Map<String, Integer> cache, int end) {
        String str1 = a.substring(0, end + 1);
        String str2 = b.substring(0, end + 1);
        String cacheKey = str1 + "-" + str2;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        int result = Integer.MAX_VALUE;
        if (str1.equals(str2)) {
            result = 0;
        } else {
            if (a.charAt(end) == b.charAt(end)) {
                result = kSimilarity(a, b, cache, end - 1);
            } else {
                for (int i = 0; i < end; i++) {
                    if (a.charAt(i) == b.charAt(end)) {
                        String part1 = i == 0 ? "" : a.substring(0, i);
                        String part3 = i == end - 1 ? "" : a.substring(i + 1, end);
                        int sim = kSimilarity(part1 + a.charAt(end) + part3, b, cache, end - 1) + 1;
                        if (sim < result) {
                            result = sim;
                        }
                    }
                }
            }
        }
        cache.put(cacheKey, result);
        return result;
    }

    public static void main(String[] args) {
        Number854 number854 = new Number854();
        Assert.assertEquals(0, number854.kSimilarity("aaa", "aaa"));
        Assert.assertEquals(2, number854.kSimilarity("abc", "bca"));
        Assert.assertEquals(2, number854.kSimilarity("abac", "baca"));
        Assert.assertEquals(2, number854.kSimilarity("aabc", "abca"));
    }
}
