package com.maginazt.page3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaotao on 2016/9/12.
 */
public class Number216 {

    private static boolean[] occupied = new boolean[10];

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k > 0 && k < 10){
            Arrays.fill(occupied, false);
            find(result, 1, k, n);
        }
        return result;
    }

    private void find(List<List<Integer>> result, int start, int k, int sum) {
        if(10-start >= k){
            if(k == 1){
                if(sum >0 && sum < 10 && !occupied[sum]){
                    List<Integer> one = new ArrayList<>();
                    for(int i=1;i<10;i++)
                        if(occupied[i])
                            one.add(i);
                    one.add(sum);
                    result.add(one);
                }
            }
            else{
                int min = (start+start+k-1)*k/2;
                int max = (10-k+9)*k/2;
                if(sum >= min && sum <= max){
                    if(min == max){
                        List<Integer> one = new ArrayList<>();
                        for(int i=1;i<start;i++)
                            if(occupied[i])
                                one.add(i);
                        for(int i=start;i<10;i++)
                            one.add(i);
                        result.add(one);
                    }
                    else{
                        for(int i=start;i<10;i++){
                            if(!occupied[i]){
                                if(sum-i > i){
                                    occupied[i] = true;
                                    find(result, i+1, k-1, sum-i);
                                    occupied[i] = false;
                                }
                                else
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Number216().combinationSum3(9,45));
    }
}
