package com.maginazt.page6;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaotao
 * @date: 2020/11/27 17:22
 */
public class Number546 {

    public int removeBoxes(int[] boxes) {
        Map<String, Integer> numCache = new HashMap<>();
        long bml = 0;
        long bmh = 0;
        for (int i = 0; i < boxes.length; i++) {
            int bit = i % 64;
            if (i >= 64) {
                bmh |= 1 << bit;
            } else {
                bml |= 1 << bit;
            }
        }
        return removeBoxes(numCache, bml, bmh, boxes);
    }

    private int removeBoxes(Map<String, Integer> numCache, long bitmapLow, long bitmapHigh, int[] boxes) {
        String cacheKey = boxes.length > 64 ? bitmapHigh + "-" + bitmapLow : String.valueOf(bitmapLow);
        if (numCache.containsKey(cacheKey)) {
            return numCache.get(cacheKey);
        }
        int num = 0;
        int begin = 0;
        boolean firstNum = true;
        for (int i = 0; i < boxes.length; i++) {
            if (!isSet(bitmapLow, bitmapHigh, i)) {
                continue;
            }
            if (firstNum) {
                begin = i;
                firstNum = false;
            }
            if (boxes[i] != boxes[begin]) {
                int end = i - 1;
                long bml = bitmapLow;
                long bmh = bitmapHigh;
                int actualNum = 0;
                for (int j = begin; j <= end; j++) {
                    if (!isSet(bitmapLow, bitmapHigh, j)) {
                        continue;
                    }
                    int bit = j % 64;
                    if (j >= 64) {
                        bmh &= ~(1 << bit);
                    } else {
                        bml &= ~(1 << bit);
                    }
                    ++actualNum;
                }
                int score = actualNum * actualNum + ((bml == 0 && bmh == 0) ? 0 : removeBoxes(numCache, bml, bmh, boxes));
                if (score > num) {
                    num = score;
                }
                begin = i;
            }
        }
        long bml = bitmapLow;
        long bmh = bitmapHigh;
        int actualNum = 0;
        for (int j = begin; j < boxes.length; j++) {
            if (!isSet(bitmapLow, bitmapHigh, j)) {
                continue;
            }
            int bit = j % 64;
            if (j >= 64) {
                bmh &= ~(1 << bit);
            } else {
                bml &= ~(1 << bit);
            }
            ++actualNum;
        }
        int score = actualNum * actualNum + ((bml == 0 && bmh == 0) ? 0 : removeBoxes(numCache, bml, bmh, boxes));
        if (score > num) {
            num = score;
        }
        numCache.put(cacheKey, num);
        return num;
    }

    private boolean isSet(long bitmapLow, long bitmapHigh, int i) {
        long bitmap = i >= 64 ? bitmapHigh : bitmapLow;
        int bit = i % 64;
        return (bitmap & (1 << bit)) > 0;
    }

    public static void main(String[] args) {
        Number546 number546 = new Number546();
//        Assert.assertEquals(23, number546.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
        Assert.assertEquals(199, number546.removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}));
    }
}
