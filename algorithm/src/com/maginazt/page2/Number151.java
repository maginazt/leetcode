package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/31.
 */
public class Number151 {

    private static StringBuilder sb = new StringBuilder();

    public String reverseWords(String s) {
        sb.delete(0, sb.length());
        if(s != null){
            char[] source = s.toCharArray();
            int wordEndIndex = -1;
            int i=source.length-1;
            while (i>=0){
                if(source[i] != ' '){
                    if(wordEndIndex == -1){
                        wordEndIndex = i;
                    }
                    if(i == 0 || source[i-1] == ' '){
                        sb.append(source, i, wordEndIndex-i+1).append(' ');
                        wordEndIndex = -1;
                    }
                }
                --i;
            }
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Number151().reverseWords("  the sk y   is blue  "));
    }
}
