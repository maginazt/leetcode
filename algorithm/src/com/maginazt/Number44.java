package com.maginazt;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Number44 {

    public boolean isMatch(String s, String p) {
        if("".equals(s) && "".equals(p)){
            return true;
        }
        else if("".equals(p))
            return false;
        int strLength = s.length();
        int patternLength = p.length();
        boolean[][] subproblems = new boolean[strLength+1][patternLength];
        //empty string at the end
        if(p.charAt(patternLength-1) == '*')
            subproblems[strLength][patternLength-1] = true;
        else
            subproblems[strLength][patternLength-1] = false;
        for(int i=patternLength-2;i>=0;i--){
            subproblems[strLength][i] = subproblems[strLength][i+1] && (p.charAt(i) == '*');
        }
        //last pattern
        if(strLength>0){
            if(p.charAt(patternLength-1) == '*' || p.charAt(patternLength-1) == '?' || p.charAt(patternLength-1) == s.charAt(strLength-1))
                subproblems[strLength-1][patternLength-1] = true;
            else
                subproblems[strLength-1][patternLength-1] = false;
            for(int i=strLength-2;i>=0;i--)
                subproblems[i][patternLength-1] = p.charAt(patternLength-1) == '*';
        }
        for(int sIndex=strLength-1;sIndex>=0;sIndex--)
            for(int pIndex=patternLength-2;pIndex>=0;pIndex--){
                if(p.charAt(pIndex) == '*')
                    subproblems[sIndex][pIndex] = subproblems[sIndex+1][pIndex] || subproblems[sIndex][pIndex+1];
                else
                    subproblems[sIndex][pIndex] = (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex)) && subproblems[sIndex+1][pIndex+1];
            }
        return subproblems[0][0];
    }

    public static void main(String[] args) {
//        "abefcdgiescdfimde"
//        "ab*cd?i*de"
        System.out.println(new Number44().isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
//        System.out.println(new Number44().isMatch("", "**ab*"));
//        System.out.println(new Number44().isMatch("abefcdfimde", "ab*cd?i*de"));
//        System.out.println(new Number44().isMatch("abefcdfimde", "ab*cd?i*de"));
    }
}
