package com.maginazt.page9;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/30 16:21
 */
public class Number824 {

    public String toGoatLatin(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0))) {
                stringBuilder.append(word).append("ma");
            } else {
                stringBuilder.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            for (int k = 0; k <= i; k++) {
                stringBuilder.append('a');
            }
            if (i != words.length - 1) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        Number824 number824 = new Number824();
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", number824.toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", number824.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
