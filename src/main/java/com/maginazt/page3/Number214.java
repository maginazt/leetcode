package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/9.
 */
public class Number214 {

    private static StringBuilder sb = new StringBuilder();

    public String shortestPalindrome(String s) {
        if(!"".equals(s)){
            sb.delete(0, sb.length());
            int startIndex = findMaxPalindrome(s);
            for(int i=s.length()-1;i>startIndex;i--)
                sb.append(s.charAt(i));
            sb.append(s);
            return sb.toString();
        }
        return "";
    }

    private int findMaxPalindrome(String s) {
        int result = 0;
        for(int right=s.length()-1;right>0;right--)
            if(isPalindrome(s, 0, right)){
                result = right;
                break;
            }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            ++start;
            --end;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number214().shortestPalindrome("abcd"));
    }
}
