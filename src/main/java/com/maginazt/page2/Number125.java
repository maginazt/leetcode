package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/18.
 */
public class Number125 {

    public boolean isPalindrome(String s) {
        if(s == null || "".equals(s))
            return true;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            while (left < arr.length && !isAlphanumeric(arr[left]))
                ++left;
            while (right >= 0 && !isAlphanumeric(arr[right]))
                --right;
            if(left >= right)
                break;
            if(!isEqualIgnoreCase(arr[left], arr[right]))
                return false;
            ++left;
            --right;
        }
        return true;
    }

    private boolean isAlphanumeric(char c){
        return c >= 'a' && c <= 'z' || c >='A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private boolean isEqualIgnoreCase(char c1, char c2){
        return Character.toUpperCase(c1) == Character.toUpperCase(c2);
    }

    public static void main(String[] args) {
        System.out.println(new Number125().isPalindrome("2race ae car3"));
    }
}
