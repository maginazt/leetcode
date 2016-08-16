package com.maginazt.page1;

/**
 * Created by zhaotao on 16/8/14.
 */
public class Number87 {

    private static int[][][] cache;

    public boolean isScramble(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        cache = new int[arr1.length][arr2.length][arr1.length];
        return isScramble(arr2, 0, arr2.length-1, arr1, 0, arr1.length-1);
    }

    private boolean isScramble(char[] target, int start, int stop, char[] original, int begin, int end) {
        System.out.println("("+start+","+stop+") --- ("+begin+","+end+")");
        if(cache[start][begin][stop-start] > 0)
            return cache[start][begin][stop-start] == 1 ? true : false;
        boolean result = false;
        if(start == stop)
            result = target[start] == original[begin];
        else{
            //possible tree split point
            for(int i=start;i<stop;i++){
                int offset = i-start;
                if(isScramble(target, start, i, original, begin, begin+offset) && isScramble(target, i+1, stop, original, begin+offset+1, end)){
                    result = true;
                    break;
                }
                if(isScramble(target, start, i, original, end-offset, end) && isScramble(target, i+1, stop, original, begin, end-offset-1)){
                    result = true;
                    break;
                }
            }
        }
        cache[start][begin][stop-start] = result ? 1 : 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number87().isScramble("rgtee", "great"));
    }
}
