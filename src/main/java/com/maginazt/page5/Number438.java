package com.maginazt.page5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaotao
 * @date: 2020/11/16 11:11
 */
public class Number438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int[] feature = calculateFeature(p);
        firstApply(feature, s, p.length());
        if (allZero(feature)) {
            result.add(0);
        }
        int end = s.length() - p.length();
        for (int i = 1; i <= end; i++) {
            ++feature[s.charAt(i - 1) - 'a'];
            --feature[s.charAt(i + p.length() - 1) - 'a'];
            if (allZero(feature)) {
                result.add(i);
            }
        }
        return result;
    }

    private void firstApply(int[] feature, String s, int length) {
        for (int i = 0; i < length; i++) {
            --feature[s.charAt(i) - 'a'];
        }
    }

    private boolean allZero(int[] feature) {
        for (int i = 0; i < feature.length; i++) {
            if (feature[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] calculateFeature(String p) {
        int[] feature = new int['z' - 'a' + 1];
        for (int i = 0; i < p.length(); i++) {
            ++feature[p.charAt(i) - 'a'];
        }
        return feature;
    }

    public static void main(String[] args) {
        Number438 number438 = new Number438();
        System.out.println(number438.findAnagrams("cbaebabacd", "abc"));
        System.out.println(number438.findAnagrams("abab", "ab"));
    }
}
