package com.maginazt.page6;

import java.util.Arrays;

/**
 * @author zhaotao
 * @date 2018/2/3
 */
public class Number564 {

    public String nearestPalindromic(String n) {
        char[] chars = n.toCharArray();
        //特殊情况1：单个数字
        if (chars.length == 1) {
            decrease(chars, 0, chars.length - 1);
            return new String(chars);
        }
        //特殊情况2：10的幂
        if (isTens(chars)) {
            decrease(chars, 0, chars.length - 1);
            return new String(chars, 1, chars.length - 1);
        }
        chars = solve(chars);
        if (chars[0] == '0') {
            return new String(chars, 1, chars.length - 1);
        } else {
            return new String(chars);
        }
    }

    private boolean isTens(char[] chars) {
        int sum = 0;
        for (char c : chars) {
            sum += c - '0';
        }
        return sum == 1;
    }

    private char[] solve(char[] chars) {
        char[] charsCopy = Arrays.copyOf(chars, chars.length);
        long value = toLong(chars);
        int midIndex = chars.length / 2;
        int presum = override(chars);
        //已经是回文数字了
        if (presum > 0) {
            //特殊情况1：10的幂+1
            if (presum == 1) {
                Arrays.fill(chars, '9');
                chars[0] = '0';
            }
            //特殊情况2：10的幂-1
            else if (presum == midIndex * 9) {
                chars = new char[chars.length + 1];
                Arrays.fill(chars, '0');
                chars[0] = '1';
                chars[chars.length - 1] = '1';
            } else {
                //1.向前看
                long before = lookForward(chars);
                //2.向后看
                long after = lookAfterward(charsCopy);
                return findFit(value, before, after, chars.length);
            }
        } else {
            long newValue = toLong(chars);
            long otherValue = newValue < value ? lookAfterward(charsCopy) : lookForward(charsCopy);
            return findFit(value, newValue, otherValue, chars.length);
        }
        return chars;
    }

    private char[] findFit(long value, long v1, long v2, int length) {
        long before = v1 < v2 ? v1 : v2;
        long after = v1 > v2 ? v1 : v2;
        long bd = Math.abs(value - before);
        long ad = Math.abs(value - after);
        if (ad < bd) {
            return toChars(after, length);
        } else {
            return toChars(before, length);
        }
    }

    private char[] toChars(long value, int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) (value % 10 + '0');
            value /= 10;
        }
        return chars;
    }

    private long lookAfterward(char[] chars) {
        int end = chars.length % 2 == 0 ? chars.length / 2 - 1 : chars.length / 2;
        increase(chars, 0, end);
        override(chars);
        return toLong(chars);
    }

    private long lookForward(char[] chars) {
        int end = chars.length % 2 == 0 ? chars.length / 2 - 1 : chars.length / 2;
        decrease(chars, 0, end);
        override(chars);
        return toLong(chars);
    }

    private long toLong(char[] chars) {
        long result = 0;
        for (int i = 0; i < chars.length; i++) {
            result = result * 10 + (chars[i] - '0');
        }
        return result;
    }

    private void decrease(char[] chars, int start, int end) {
        for (int i = end; i >= start; i--) {
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
                break;
            }
        }
    }

    private void increase(char[] chars, int start, int end) {
        for (int i = end; i >= start; i--) {
            if (chars[i] == '9') {
                chars[i] = '0';
            } else {
                chars[i] += 1;
                break;
            }
        }
    }

    private int override(char[] chars) {
        boolean isPalindromic = true;
        int sum = 0;
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                chars[end] = chars[start];
                isPalindromic = false;
            }
            sum += chars[start] - '0';
            ++start;
            --end;
        }
        return isPalindromic ? sum : -1;
    }

    public static void main(String[] args) {
        Number564 solution = new Number564();
        System.out.println(solution.nearestPalindromic("11011"));
        System.out.println(solution.nearestPalindromic("999"));
        System.out.println(solution.nearestPalindromic("1001"));
        System.out.println(solution.nearestPalindromic("2002"));
        System.out.println(solution.nearestPalindromic("1283"));
    }
}
