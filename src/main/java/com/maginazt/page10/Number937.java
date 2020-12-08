package com.maginazt.page10;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/4 18:28
 */
public class Number937 {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            int contentIndex1 = o1.indexOf(' ') + 1;
            int contentIndex2 = o2.indexOf(' ') + 1;
            char c1 = o1.charAt(contentIndex1);
            char c2 = o2.charAt(contentIndex2);
            boolean isDigit1 = c1 >= '0' && c1 <= '9';
            boolean isDigit2 = c2 >= '0' && c2 <= '9';
            if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1) {
                return 1;
            } else if (isDigit2) {
                return -1;
            } else {
                int rs = o1.substring(contentIndex1).compareTo(o2.substring(contentIndex2));
                if (rs == 0) {
                    return o1.substring(0, contentIndex1 - 1).compareTo(o2.substring(0, contentIndex2 - 1));
                } else {
                    return rs;
                }
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        Number937 number937 = new Number937();
        System.out.println(Arrays.toString(number937.reorderLogFiles(new String[]{"g1 act car", "a2 act car"})));
        System.out.println(Arrays.toString(number937.reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"})));
        System.out.println(Arrays.toString(number937.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }
}
