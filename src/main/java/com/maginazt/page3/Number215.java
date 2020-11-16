package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/9/12.
 */
public class Number215 {

    public int findKthLargest(int[] nums, int k) {
        randomSwap(nums);
        return findKthLargest(nums, 0, nums.length-1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if(start < end){
            int p = partition(nums, start, end);
            int pos = p - start + 1;
            if(pos == k)
                return nums[p];
            else if(pos > k)
                return findKthLargest(nums, start, p-1, k);
            else
                return findKthLargest(nums, p+1, end, k-pos);
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int i = start-1;
        for(int j=start;j<end;j++){
            if(nums[j] > nums[end]){
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void randomSwap(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            int nextIndex = (int)(Math.random()*(nums.length-i)+i);
            int tmp = nums[i];
            nums[i] = nums[nextIndex];
            nums[nextIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 2, 1};
        System.out.println(new Number215().findKthLargest(nums, 5));
    }
}
