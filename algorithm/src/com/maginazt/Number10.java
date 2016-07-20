package com.maginazt;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Number10 {
    public boolean isMatch(String s, String p) {
        if(s==null)
            s="";
        if((p==null || "".equals(p)) && "".equals(s))
            return true;
        //compile pattern
        char[] patternRaw = new char[p.length()];
        boolean[] isWildcardRaw = new boolean[patternRaw.length];
        int index = 0;
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            if('*'!=c){
                patternRaw[index] = c;
                if(i+1<p.length() && p.charAt(i+1)=='*')
                    isWildcardRaw[index] = true;
                else
                    isWildcardRaw[index] = false;
                ++index;
            }
        }
        //index is the bound of pattern
        char[] pattern = new char[index];
        boolean[] isWildcard = new boolean[index];
        System.arraycopy(patternRaw, 0, pattern, 0, index);
        System.arraycopy(isWildcardRaw, 0, isWildcard, 0, index);
        return isMatch(s.toCharArray(), pattern, isWildcard, 0, 0);
    }

    //recursively find a match
    private boolean isMatch(char[] str, char[] pattern, boolean[] isWildcard, int strIndex, int patternIndex) {
        //empty string
        if(strIndex == str.length){
            //find a match
            if(patternIndex == pattern.length)
                return true;
            //only a wildcard can match an empty string
            else if(!isWildcard[patternIndex])
                return false;
            else
                return isMatch(str, pattern, isWildcard, strIndex, patternIndex+1);
        }
        //no more patterns
        if(patternIndex == pattern.length)
            return false;
        if(!isWildcard[patternIndex]){
            if(isMatch(str[strIndex], pattern[patternIndex]))
                return isMatch(str, pattern, isWildcard, strIndex+1, patternIndex+1);
            else
                return false;
        }
        else{
            if(isMatch(str[strIndex], pattern[patternIndex]))
                return isMatch(str, pattern, isWildcard, strIndex+1, patternIndex) || isMatch(str, pattern, isWildcard, strIndex, patternIndex+1);
            else
                return isMatch(str, pattern, isWildcard, strIndex, patternIndex+1);
        }
    }

    private boolean isMatch(char s, char p){
        return '.' == p || s == p;
    }

    public static void main(String[] args) {
        Number10 n = new Number10();
        System.out.println(n.isMatch("aaaa", ".*a"));
    }
}
