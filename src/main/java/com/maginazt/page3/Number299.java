package com.maginazt.page3;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/10/11.
 */
public class Number299 {

    private static final int[] secretCounts = new int[10];
    private static final int[] guessCounts = new int[10];

    public String getHint(String secret, String guess) {
        clear();
        int bulls = 0;
        int cows = 0;
        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g)
                ++bulls;
            else{
                ++secretCounts[s-'0'];
                ++guessCounts[g-'0'];
            }
        }
        for(int i=0;i<secretCounts.length;i++)
            cows += Math.min(secretCounts[i], guessCounts[i]);
        return bulls+"A"+cows+"B";
    }

    private void clear() {
        Arrays.fill(secretCounts, 0);
        Arrays.fill(guessCounts, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Number299().getHint("1123","0111"));
    }
}
