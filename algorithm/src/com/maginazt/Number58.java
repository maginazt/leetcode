package com.maginazt;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Number58 {

    public int lengthOfLastWord(String s) {
        int length = 0;
        int wordStartIndex = -1;
        boolean inWord = false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ' '){
                if(!inWord){
                    wordStartIndex = i;
                    inWord = true;
                }
            }
            else{
                if(inWord){
                    length = i-wordStartIndex;
                    inWord = false;
                }
            }
        }
        if(inWord)
            length = s.length()-wordStartIndex;
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Number58().lengthOfLastWord("hello adsff sdaf "));
    }
}
