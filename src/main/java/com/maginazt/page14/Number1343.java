package com.maginazt.page14;

/**
 * @author: zhaotao
 * @date: 2020/11/16 15:25
 */
public class Number1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr == null || arr.length < k) {
            return 0;
        }
        int result = 0;
        double avg = firstCalculate(arr, k);
        if (avg >= threshold) {
            ++result;
        }
        int end = arr.length - k;
        for (int i = 1; i <= end; i++) {
            avg += (arr[i + k - 1] - arr[i - 1]) * 1.0 / k;
            if (avg >= threshold) {
                ++result;
            }
        }
        return result;
    }

    private double firstCalculate(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum * 1.0 / k;
    }

    public static void main(String[] args) {
        Number1343 number1343 = new Number1343();
        System.out.println(number1343.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(number1343.numOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 0));
        System.out.println(number1343.numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
        System.out.println(number1343.numOfSubarrays(new int[]{7, 7, 7, 7, 7, 7, 7}, 7, 7));
    }
}
