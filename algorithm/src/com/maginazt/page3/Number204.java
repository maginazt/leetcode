package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/6.
 */
public class Number204 {

//    public int countPrimes(int n) {
//        if(n < 2)
//            return 0;
//        boolean[] isNotPrime = new boolean[n+1];
//        int result = 0;
//        int limit = (int) Math.sqrt(n);
//        for(int i=2;i<=n;i++){
//            if(!isNotPrime[i]){
//                ++result;
//                if(i <= limit){
//                    int start = i;
//                    int prod = i*start;
//                    while (prod > 0 && prod <= n){
//                        isNotPrime[prod] = true;
//                        ++start;
//                        prod = i*start;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public int countPrimes(int n) {
        if(n < 2)
            return 0;
        boolean[] isNotPrime = new boolean[n];
        int result = 0;
        int limit = (int) Math.sqrt(n);
        for(int i=2;i<n;i++){
            if(!isNotPrime[i]){
                ++result;
                if(i <= limit){
                    int start = i;
                    while (i * start < n){
                        isNotPrime[i*start] = true;
                        ++start;
                    }
                }
            }
        }
        return result;
    }

//    public int countPrimes(int n) {
//        boolean[] isPrime = new boolean[n];
//        for (int i = 2; i < n; i++) {
//            isPrime[i] = true;
//        }
//        // Loop's ending condition is i * i < n instead of i < sqrt(n)
//        // to avoid repeatedly calling an expensive function sqrt().
//        for (int i = 2; i * i < n; i++) {
//            if (!isPrime[i]) continue;
//            for (int j = i * i; j < n; j += i) {
//                if(j == 499979)
//                    System.out.println(i);
//                isPrime[j] = false;
//            }
//        }
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrime[i]) {
//                count++;
//            }
//        }
//        return count;
//    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Number204().countPrimes(499979));
    }
}
