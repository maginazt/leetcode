package com.maginazt.page5;

/**
 * @author zhaotao
 * @date 2018/2/5
 */
public class Number420 {

    private boolean hasLower;
    private boolean hasUpper;
    private boolean hasDigit;

    private int charsetSize;
    private int length;
    private char prev;
    private int dupCount;

    public int strongPasswordChecker(String s) {
        init(s);
        return doCheck(s, 0);
    }

    private int doCheck(String s, int start) {
        int operation = 0;
        for (int i = start; i < s.length(); i++) {
            char cur = s.charAt(i);
            updateFlag(cur);
            if (dupCount > 0 && cur == prev) {
                ++dupCount;
                if (dupCount == 3) {
                    //prefer insert
                    if (length < 6) {
                        ++length;
                        ++charsetSize;
                        dupCount = 0;
                    }
                    //prefer delete or replace
                    //backtrace
                    else if (length > 20) {
                        int originLength = length;
                        int originDupCount = dupCount;
                        int originCharsetSize = charsetSize;
                        char originPrev = prev;
                        //1.delete
                        --length;
                        dupCount = 2;
                        int sub1 = doCheck(s, i + 1);
                        //2.replace
                        length = originLength;
                        dupCount = originDupCount;
                        charsetSize = originCharsetSize;
                        prev = originPrev;
                        ++charsetSize;
                        dupCount = 0;
                        int sub2 = doCheck(s, i + 1);
                        operation += 1 + Math.min(sub1, sub2);
                        return operation;
                    }
                    //prefer replace
                    else {
                        ++charsetSize;
                        dupCount = 0;
                    }
                    ++operation;
                }
            } else {
                prev = cur;
                dupCount = 1;
            }
        }
        return closure(operation);
    }

    private int closure(int operation) {
        if (hasLower) {
            ++charsetSize;
        }
        if (hasUpper) {
            ++charsetSize;
        }
        if (hasDigit) {
            ++charsetSize;
        }
        if (length < 6) {
            int ops = 6 - length;
            operation += ops;
            charsetSize += ops;
        } else if (length > 20) {
            int ops = length - 20;
            operation += ops;
        }
        if (charsetSize < 3) {
            operation += 3 - charsetSize;
        }
        return operation;
    }

    private void init(String s) {
        hasLower = false;
        hasUpper = false;
        hasDigit = false;
        charsetSize = 0;
        length = s.length();
        prev = 0;
        dupCount = 0;
    }

    private void updateFlag(char c) {
        if (c >= 'a' && c <= 'z') {
            hasLower = true;
        } else if (c >= 'A' && c <= 'Z') {
            hasUpper = true;
        } else if (c >= '0' && c <= '9') {
            hasDigit = true;
        }
    }

    public static void main(String[] args) {
        Number420 solution = new Number420();
        System.out.println(solution.strongPasswordChecker("aaa"));
//        System.out.println(solution.strongPasswordChecker("ABABABABABABABABABAB1"));
//        System.out.println(solution.strongPasswordChecker("1234567890123456Baaaaa"));
//        System.out.println(solution.strongPasswordChecker("1111111111"));
//        System.out.println(solution.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(solution.strongPasswordChecker("1Abababcaaaabababababa"));
//        System.out.println(solution.strongPasswordChecker("aaaabbaaabbaaa123456A"));
    }
}
