package com.maginazt.page9;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/12/2 16:58
 */
public class Number875 {

    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int num : piles) {
            if (num > high) {
                high = num;
            }
        }
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = getHours(piles, mid);
            if (hours <= H) {
                if (mid < result) {
                    result = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private int getHours(int[] piles, int num) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile / num + (pile % num == 0 ? 0 : 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Number875 number875 = new Number875();
        Assert.assertEquals(2, number875.minEatingSpeed(new int[]{312884470}, 312884469));
        Assert.assertEquals(4, number875.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        Assert.assertEquals(30, number875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        Assert.assertEquals(23, number875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
