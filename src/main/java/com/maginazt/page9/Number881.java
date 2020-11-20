package com.maginazt.page9;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/20 10:10
 */
public class Number881 {

    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] > limit) {
                ++result;
                --j;
            } else {
                ++i;
                --j;
                ++result;
            }
        }
        if (i == j) {
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        Number881 number881 = new Number881();
        Assert.assertEquals(1, number881.numRescueBoats(new int[]{1, 2}, 3));
        Assert.assertEquals(3, number881.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        Assert.assertEquals(4, number881.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        Assert.assertEquals(1, number881.numRescueBoats(new int[]{2, 2}, 6));
    }
}
