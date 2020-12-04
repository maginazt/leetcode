package com.maginazt.page16;

/**
 * @author: zhaotao
 * @date: 2020/11/30 15:34
 */
public class Number1576 {

    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '?') {
                continue;
            }
            char left = i == 0 ? 0 : arr[i - 1];
            char right = i == arr.length - 1 ? 0 : arr[i + 1] == '?' ? 0 : arr[i + 1];
            arr[i] = findChar(left, right);
        }
        return new String(arr);
    }

    private char findChar(char left, char right) {
        for (char i = 'a'; i <= 'z'; i++) {
            if (i != left && i != right) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Number1576 number1576 = new Number1576();
        System.out.println(number1576.modifyString("?zs"));
        System.out.println(number1576.modifyString("ubv?w"));
        System.out.println(number1576.modifyString("j?qg??b"));
        System.out.println(number1576.modifyString("??yw?ipkj?"));
    }
}
