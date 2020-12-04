package com.maginazt.page9;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zhaotao
 * @date: 2020/12/1 09:04
 */
public class Number846 {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        Arrays.sort(hand);
        LinkedList<int[]> ranges = new LinkedList<>();
        for (int i = 0; i < hand.length; i++) {
            int[] range = findRange(ranges);
            if (range == null) {
                range = new int[2];
                range[0] = hand[i] + 1;
                range[1] = hand[i] + W - 1;
                ranges.add(range);
            } else {
                if (range[0] < hand[i]) {
                    return false;
                } else if (range[0] == hand[i]) {
                    range[0] = hand[i] + 1;
                    if (range[0] > range[1]) {
                        ranges.remove(range);
                    }
                } else {
                    range = new int[2];
                    range[0] = hand[i] + 1;
                    range[1] = hand[i] + W - 1;
                    ranges.add(range);
                }
            }
        }
        return ranges.isEmpty();
    }

    private int[] findRange(LinkedList<int[]> ranges) {
        if (ranges.isEmpty()) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        int[] result = null;
        for (int[] range : ranges) {
            if (range[0] < min) {
                min = range[0];
                result = range;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Number846 number846 = new Number846();
        Assert.assertTrue(number846.isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 3));
        Assert.assertFalse(number846.isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
        Assert.assertTrue(number846.isNStraightHand(new int[]{5, 1}, 1));
        Assert.assertTrue(number846.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        Assert.assertFalse(number846.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        Assert.assertFalse(number846.isNStraightHand(new int[]{1, 2, 2, 3, 4, 5}, 3));
    }
}
