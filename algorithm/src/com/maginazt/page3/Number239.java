package com.maginazt.page3;

import java.util.Arrays;

/**
 * Created by zhaotao on 2016/9/29.
 */
public class Number239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 2)
            return nums;
        int[] result = new int[nums.length-k+1];
        //numIndex -> heapIndex
        int[] indexInHeap = new int[nums.length];
        //heapIndex -> numIndex
        int[] heap = buildHeap(nums, k, indexInHeap);
        result[0] = nums[heap[0]];
        int index = 1;
        for(int rightWindow=k;rightWindow<nums.length;rightWindow++, index++){
            int leftWindow = rightWindow - k + 1;
            int changeIndex = indexInHeap[leftWindow-1];
            adjust(nums, heap, changeIndex, rightWindow, indexInHeap);
            result[index] = nums[heap[0]];
        }
        return result;
    }

    private void adjust(int[] nums, int[] heap, int changeIndex, int newIndex, int[] indexInHeap) {
        int oldNum = nums[heap[changeIndex]];
        heap[changeIndex] = newIndex;
        indexInHeap[newIndex] = changeIndex;
        if(nums[newIndex] < oldNum)
            maxHeapify(nums, heap, changeIndex, indexInHeap);
        else if(nums[newIndex] > oldNum){
            int cur = changeIndex;
            int p = (cur-1)/2;
            while (cur != p && nums[heap[p]] < nums[newIndex]){
                int tmp = heap[p];
                heap[p] = heap[cur];
                heap[cur] = tmp;
                tmp = indexInHeap[heap[p]];
                indexInHeap[heap[p]] = indexInHeap[heap[cur]];
                indexInHeap[heap[cur]] = tmp;
                cur = p;
                p = (cur-1)/2;
            }
        }
    }

    private int[] buildHeap(int[] nums, int k, int[] indexInHeap) {
        int[] heap = new int[k];
        for(int i=0;i<k;i++){
            heap[i] = i;
            indexInHeap[i] = i;
        }
        for(int i=k/2;i>=0;i--)
            maxHeapify(nums, heap, i, indexInHeap);
        return heap;
    }

    private void maxHeapify(int[] nums, int[] heap, int p, int[] indexInHeap) {
        int leftIndex = 2*p+1;
        int rightIndex = 2*p+2;
        int largestIndex;
        if(leftIndex < heap.length && nums[heap[leftIndex]] > nums[heap[p]])
            largestIndex = leftIndex;
        else
            largestIndex = p;
        if(rightIndex < heap.length && nums[heap[rightIndex]] > nums[heap[largestIndex]])
            largestIndex = rightIndex;
        if(largestIndex != p){
            int tmp = heap[p];
            heap[p] = heap[largestIndex];
            heap[largestIndex] = tmp;
            tmp = indexInHeap[heap[p]];
            indexInHeap[heap[p]] = indexInHeap[heap[largestIndex]];
            indexInHeap[heap[largestIndex]] = tmp;
            maxHeapify(nums, heap, largestIndex, indexInHeap);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Number239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 5)));
    }
}
