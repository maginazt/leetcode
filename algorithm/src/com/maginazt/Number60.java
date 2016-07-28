package com.maginazt;

import java.util.*;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Number60 {

    private static int[] fac = {1,1,2,6,24,120,720,5040,40320,362880};

    private static boolean[] excludes = new boolean[10];

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int position = k-1;
        Arrays.fill(excludes, false);
        int left = n-1;
        for(int i=n;i>=1;i--){
            int next = getNumber(n, position,left);
            sb.append(next);
            excludes[next] = true;
            position = position % fac[i-1];
            --left;
        }
        return sb.toString();
    }

    private int getNumber(int n, int position, int left) {
        int order = position / fac[left];
        int index = 0;
        for(int i=1;i<=n;i++){
            if(excludes[i])
                continue;
            else{
                if(index == order)
                    return i;
                else
                    ++index;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Number60().getPermutation(8,8590));
    }

}
