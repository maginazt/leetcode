package com.maginazt.page6;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaotao
 * @date: 2020/12/7 17:14
 */
public class Number524 {

    public String findLongestWord(String s, List<String> d) {
        return d.stream()
                .filter(o -> isSubSequence(s, o))
                .min((o1, o2) -> {
                    int len1 = o1.length();
                    int len2 = o2.length();
                    if (len1 < len2) {
                        return 1;
                    } else if (len1 > len2) {
                        return -1;
                    } else {
                        return o1.compareTo(o2);
                    }
                })
                .orElse("");
    }

    private boolean isSubSequence(String s, String o) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < s.length() && idx2 < o.length()) {
            if (s.charAt(idx1) == o.charAt(idx2)) {
                ++idx1;
                ++idx2;
            } else {
                ++idx1;
            }
        }
        return idx2 == o.length();
    }

    public static void main(String[] args) {
        Number524 number524 = new Number524();
        Assert.assertEquals("ewaf", number524.findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));
        Assert.assertEquals("apple", number524.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        Assert.assertEquals("a", number524.findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }
}
