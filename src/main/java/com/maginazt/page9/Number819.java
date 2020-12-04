package com.maginazt.page9;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaotao
 * @date: 2020/12/3 13:51
 */
public class Number819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = countWord(paragraph);
        for (String ban : banned) {
            wordCount.remove(ban);
        }
        return wordCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private Map<String, Integer> countWord(String paragraph) {
        Map<String, Integer> wordCount = new HashMap<>();
        int wordBegin = -1;
        for (int i = 0; i < paragraph.length(); i++) {
            if (isLetter(paragraph.charAt(i))) {
                if (wordBegin == -1) {
                    wordBegin = i;
                }
            } else {
                if (wordBegin != -1) {
                    String word = buildWord(paragraph, wordBegin, i);
                    wordCount.merge(word, 1, Integer::sum);
                    wordBegin = -1;
                }
            }
        }
        if (wordBegin != -1) {
            String word = buildWord(paragraph, wordBegin, paragraph.length());
            wordCount.merge(word, 1, Integer::sum);
        }
        return wordCount;
    }

    private String buildWord(String paragraph, int begin, int end) {
        char[] chars = new char[end - begin];
        for (int i = begin; i < end; i++) {
            char c = paragraph.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c - 'A' + 'a');
            }
            chars[i - begin] = c;
        }
        return new String(chars);
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        Number819 number819 = new Number819();
        Assert.assertEquals("ball", number819.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
