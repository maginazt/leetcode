package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/8/17.
 */
public class Number115 {

//    private static int[][] cache;

    public int numDistinct(String s, String t) {
        if("".equals(s) || "".equals(t) || s.length() < t.length())
            return 0;
        int sourceLength = s.length();
        int targetLength = t.length();
        int[][] counts = new int[sourceLength][targetLength];
        for(int sourceIndex = sourceLength-1;sourceIndex>=0;sourceIndex--){
            for(int targetIndex = targetLength-1;targetIndex>=0;targetIndex--){
                int sourceLeft = sourceLength - sourceIndex;
                int targetLeft = targetLength - targetIndex;
                if(sourceLeft < targetLeft)
                    counts[sourceIndex][targetIndex] = 0;
                else{
                    if(s.charAt(sourceIndex) == t.charAt(targetIndex)){
                        if(targetLeft == 1)
                            counts[sourceIndex][targetIndex] = 1;
                        else
                            counts[sourceIndex][targetIndex] = counts[sourceIndex+1][targetIndex+1];
                        if(sourceLeft > 1)
                            counts[sourceIndex][targetIndex] += counts[sourceIndex+1][targetIndex];
                    }
                    else{
                        if(sourceLeft == 1)
                            counts[sourceIndex][targetIndex] = 0;
                        else
                            counts[sourceIndex][targetIndex] = counts[sourceIndex+1][targetIndex];
                    }
                }
            }
        }
        return counts[0][0];
//        cache = new int[s.length()][t.length()];
//        for(int i=0;i<cache.length;i++)
//            for(int j=0;j<cache[0].length;j++)
//                cache[i][j] = -1;
//        return find(s.toCharArray(), 0, t.toCharArray(), 0);
    }

//    private int find(char[] source, int sourceIndex, char[] target, int targetIndex) {
//        if(cache[sourceIndex][targetIndex] >= 0)
//            return cache[sourceIndex][targetIndex];
//        int result;
//        if(source.length-sourceIndex < target.length-targetIndex){
//            result = 0;
//        }
//        else{
//            if(source[sourceIndex] == target[targetIndex]){
//                result = targetIndex == target.length-1 ? 1 : find(source, sourceIndex+1, target, targetIndex+1) + find(source, sourceIndex+1, target, targetIndex);
//            }
//            else{
//                if(sourceIndex == source.length-1)
//                    result = 0;
//                else
//                    result = find(source, sourceIndex+1, target, targetIndex);
//            }
//        }
//        cache[sourceIndex][targetIndex] = result;
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Number115().numDistinct("aaa", "a"));
    }
}
