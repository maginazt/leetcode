package com.maginazt.page5;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/20 13:29
 */
public class Number475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int minRadius = findMinRadius(heaters, houses[i]);
            if (minRadius > maxRadius) {
                maxRadius = minRadius;
            }
        }
        return maxRadius;
    }

    private int findMinRadius(int[] heaters, int house) {
        int low = 0;
        int high = heaters.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (heaters[low] > house) {
            int range1 = heaters[low] - house;
            int range2 = low == 0 ? Integer.MAX_VALUE : house - heaters[low - 1];
            return Math.min(range1, range2);
        } else {
            int range1 = house - heaters[low];
            int range2 = low == heaters.length - 1 ? Integer.MAX_VALUE : heaters[low + 1] - house;
            return Math.min(range1, range2);
        }
    }

    public static void main(String[] args) {
        Number475 number475 = new Number475();
        Assert.assertEquals(1, number475.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        Assert.assertEquals(1, number475.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        Assert.assertEquals(3, number475.findRadius(new int[]{1, 5}, new int[]{2}));
        Assert.assertEquals(161834419, number475.findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923}, new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }
}
