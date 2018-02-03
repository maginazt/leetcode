package com.maginazt.page6;

/**
 * @author zhaotao
 * @date 2018/2/3
 */
public class Number564 {

    public String nearestPalindromic(String n) {
        char[] chars = n.toCharArray();
        solve(chars, 0, chars.length - 1);
        if (chars[0] == '0') {
            return new String(chars, 1, chars.length - 1);
        } else {
            return new String(chars);
        }
    }

    private void solve(char[] chars, int start, int end) {
        int length = end - start + 1;
        if (length % 2 == 0) {
            boolean isPalindromic = override(chars, start, end);

        } else {
            int midIndex = length / 2;
            boolean isPalindromic = override(chars, start, end);
            if (isPalindromic) {
                decrease(chars, start, midIndex);
                if (chars[start] == '0') {
                    solve(chars, start + 1, end);
                }
            }
        }
    }

    private void decrease(char[] chars, int start, int midIndex) {
        for (int i = midIndex; i >= start; i--) {
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] -= 1;
                break;
            }
        }
    }

    private boolean override(char[] modified, int start, int end) {
        boolean isPalindromic = true;
        while (start < end) {
            if (modified[start] != modified[end]) {
                modified[end] = modified[start];
                isPalindromic = false;
            }
            ++start;
            --end;
        }
        return isPalindromic;
    }

    public static void main(String[] args) {
        Number564 solution = new Number564();
        char[] chars = "10033".toCharArray();
//        solution.override(chars, 0, 4);
        solution.decrease(chars, 0, 2);
        System.out.println(new String(chars));
    }
}
