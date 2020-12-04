package com.maginazt.page13;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zhaotao
 * @date: 2020/12/1 10:28
 */
public class Number1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        Arrays.sort(nums);
        LinkedList<int[]> ranges = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] range = findRange(ranges);
            if (range == null) {
                range = new int[2];
                range[0] = nums[i] + 1;
                range[1] = nums[i] + k - 1;
                ranges.add(range);
            } else {
                if (range[0] < nums[i]) {
                    return false;
                } else if (range[0] == nums[i]) {
                    range[0] = nums[i] + 1;
                    if (range[0] > range[1]) {
                        ranges.remove(range);
                    }
                } else {
                    range = new int[2];
                    range[0] = nums[i] + 1;
                    range[1] = nums[i] + k - 1;
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
}
