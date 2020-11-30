package com.maginazt.page7;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/27 16:35
 */
public class Number667 {

    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        boolean[] container = new boolean[n + 1];
        int end = k / 2 + k % 2;
        for (int i = 0; i < end; i++) {
            arr[2 * i] = n - i;
            container[arr[2 * i]] = true;
            if (2 * i != k) {
                arr[2 * i + 1] = n - k + i;
                container[arr[2 * i + 1]] = true;
            }
        }
        int index = 2 * end;
        for (int i = container.length - 1; i > 0; i--) {
            if (!container[i]) {
                arr[index++] = i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Number667 number667 = new Number667();
        System.out.println(Arrays.toString(number667.constructArray(10, 4)));
        System.out.println(Arrays.toString(number667.constructArray(3, 1)));
        System.out.println(Arrays.toString(number667.constructArray(3, 2)));
        System.out.println(Arrays.toString(number667.constructArray(10, 9)));
        System.out.println(Arrays.toString(number667.constructArray(10, 8)));
    }
}
