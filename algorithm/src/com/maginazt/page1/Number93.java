package com.maginazt.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/16.
 */
public class Number93 {

    private static List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        result.clear();
        restore(s.toCharArray(), 0, 4, new StringBuilder());
        return result;
    }

    private void restore(char[] s, int beginIndex, int part, StringBuilder prevSoFar) {
        System.out.println("begin: "+beginIndex+", part: "+part+", prevStr: "+prevSoFar.toString());
        //prune
        int charsLeft = s.length - beginIndex;
        if(charsLeft >= part && charsLeft <= 3*part){
            if(part == 1){
                //illegal situration
                if(charsLeft > 1 && s[beginIndex] == '0')
                    return;
                String lastPart = new String(s, beginIndex, charsLeft);
                if(less255(s, beginIndex, charsLeft)){
                    prevSoFar.append(lastPart);
                    result.add(prevSoFar.toString());
                }
            }
            else{
                int prevPos = prevSoFar.length();
                prevSoFar.append(s, beginIndex, 1).append(".");
                restore(s, beginIndex+1, part-1, prevSoFar);
                prevSoFar.delete(prevPos, prevSoFar.length());
                if(s[beginIndex] != '0'){
                    //two
                    if(charsLeft > 1){
                        prevSoFar.append(s, beginIndex, 2).append(".");
                        restore(s, beginIndex+2, part-1, prevSoFar);
                        prevSoFar.delete(prevPos, prevSoFar.length());
                    }
                    //three
                    if(charsLeft > 2 && less255(s, beginIndex, 3)){
                        prevSoFar.append(s, beginIndex, 3).append(".");
                        restore(s, beginIndex+3, part-1, prevSoFar);
                        prevSoFar.delete(prevPos, prevSoFar.length());
                    }
                }
            }
        }
    }

    //determain s[beginIndex, len] is less than or equal to 255
    private boolean less255(char[] s, int beginIndex, int len) {
        if(len < 3)
            return true;
        if(len > 3)
            return false;
        if(s[beginIndex] == '2'){
            if(s[beginIndex+1] == '5'){
                return s[beginIndex+2] <= '5';
            }
            else
                return s[beginIndex+1] < '5';
        }
        else
            return s[beginIndex] < '2';
    }

    public static void main(String[] args) {
        System.out.println(new Number93().restoreIpAddresses("101023"));
    }
}
