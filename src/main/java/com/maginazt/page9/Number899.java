package com.maginazt.page9;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/25 09:02
 */
public class Number899 {

    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            return orderlyQueue(S);
        }
        int[] container = new int['z' - 'a' + 1];
        for (int i = 0; i < S.length(); i++) {
            ++container[S.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder(S.length());
        for (int i = 0; i < container.length; i++) {
            if (container[i] > 0) {
                for (int k = 0; k < container[i]; k++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }

    private String orderlyQueue(String s) {
        String result = s;
        for (int i = 1; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (tmp.compareTo(result) < 0) {
                result = tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Number899 number899 = new Number899();
        Assert.assertEquals("acb", number899.orderlyQueue("cba", 1));
        Assert.assertEquals("aaabc", number899.orderlyQueue("baaca", 3));
    }
}
