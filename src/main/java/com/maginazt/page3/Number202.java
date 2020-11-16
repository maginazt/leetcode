package com.maginazt.page3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number202 {

    private static final Set<Integer> cache = new HashSet<>();

    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        cache.clear();
        boolean result = false;
        cache.add(n);
        while (true){
            int sum = 0;
            while (n > 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if(sum == 1){
                result = true;
                break;
            }
            if(cache.contains(sum))
                break;
            cache.add(sum);
            n = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Number202().isHappy(1233121231));
    }
}
