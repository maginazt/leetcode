package com.maginazt.page5;

/**
 * @author zhaotao
 * @date 2018/2/6
 */
public class Number493 {

    private int[] cache;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        cache = new int[nums.length];
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = find(nums, start, mid) + find(nums, mid + 1, end);
        count += merge(nums, start, mid, end);
        return count;
    }

    private int merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= mid; i++) {
            cache[i] = nums[i] >> 1;
            cache[i] += Math.abs(nums[i] % 2);
        }
        System.arraycopy(nums, mid + 1, cache, mid + 1, end - mid);
        int count = 0;
        int p = start;
        int q = mid + 1;
        while (p <= mid && q <= end) {
            if (cache[p] <= cache[q]) {
                p++;
            } else {
                count += mid - p + 1;
                q++;
            }
        }
        p = start;
        q = mid + 1;
        int k = start;
        while (p <= mid && q <= end) {
            if (nums[p] < nums[q]) {
                cache[k++] = nums[p++];
            } else {
                cache[k++] = nums[q++];
            }
        }
        while (p <= mid) {
            cache[k++] = nums[p++];
        }
        while (q <= end) {
            cache[k++] = nums[q++];
        }
        System.arraycopy(cache, start, nums, start, end - start + 1);
        return count;
    }


    public static void main(String[] args) {
//        int[] arr = {-185,143,-154,-338,-269,287,214,313,165,-364,-22,-5,9,-212,46,328,-432,-47,317,206,-112,-9,-224,-207,6,198,290,27};
//        System.out.println(new Number493().reversePairs(arr));
        System.out.println(-3/2);
    }
}
