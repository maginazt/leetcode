package com.maginazt.page9;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaotao
 * @date: 2020/11/25 14:51
 */
public class Number809 {

    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        List<Character> feature = new ArrayList<>();
        List<Integer> featureCount = new ArrayList<>();
        calculateFeature(S, feature, featureCount);
        int result = 0;
        for (String word : words) {
            if (isExpressive(word, feature, featureCount)) {
                ++result;
            }
        }
        return result;
    }

    private boolean isExpressive(String word, List<Character> feature, List<Integer> featureCount) {
        char character = word.charAt(0);
        int count = 0;
        int index = 0;
        int featureIndex = 0;
        while (index < word.length()) {
            while (index < word.length() && word.charAt(index) == character) {
                ++index;
                ++count;
            }
            if (featureIndex >= feature.size()) {
                return false;
            }
            if (!feature.get(featureIndex).equals(character)) {
                return false;
            }
            if (!isCountMatch(count, featureCount.get(featureIndex))) {
                return false;
            }
            ++featureIndex;
            if (index < word.length()) {
                character = word.charAt(index);
                count = 0;
            }
        }
        return featureIndex >= feature.size();
    }

    private boolean isCountMatch(int count, int featureCount) {
        return count == featureCount || featureCount >= 3 && featureCount > count;
    }

    private void calculateFeature(String s, List<Character> feature, List<Integer> featureCount) {
        char character = s.charAt(0);
        int count = 0;
        int index = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == character) {
                ++index;
                ++count;
            }
            feature.add(character);
            featureCount.add(count);
            if (index < s.length()) {
                character = s.charAt(index);
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        Number809 number809 = new Number809();
        Assert.assertEquals(1, number809.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        Assert.assertEquals(4, number809.expressiveWords("tttttllll", new String[]{"tl", "tll", "ttll", "ttl"}));
        Assert.assertEquals(0, number809.expressiveWords("abcd", new String[]{"abc"}));
        Assert.assertEquals(0, number809.expressiveWords("heeellooo", new String[]{"heeelloooworld"}));
        Assert.assertEquals(3, number809.expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"}));
    }
}
