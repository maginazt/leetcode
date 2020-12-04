package com.maginazt.page10;

import com.alibaba.fastjson.JSON;
import com.maginazt.util.InputUtil;

/**
 * @author: zhaotao
 * @date: 2020/12/4 10:26
 */
public class Number973 {

    public int[][] kClosest(int[][] points, int K) {
        double[][] maxHeap = buildHeap(K);
        for (int i = 0; i < points.length; i++) {
            double dist = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            if (dist >= maxHeap[0][0]) {
                continue;
            }
            maxHeap[0][0] = dist;
            maxHeap[0][1] = i;
            adjustHeap(maxHeap, 0);
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < maxHeap.length; i++) {
            int pointIndex = (int) maxHeap[i][1];
            result[i] = points[pointIndex];
        }
        return result;
    }

    private void adjustHeap(double[][] maxHeap, int p) {
        int nextPos = p;
        int left = 2 * p + 1;
        if (left < maxHeap.length && maxHeap[left][0] > maxHeap[nextPos][0]) {
            nextPos = left;
        }
        int right = 2 * p + 2;
        if (right < maxHeap.length && maxHeap[right][0] > maxHeap[nextPos][0]) {
            nextPos = right;
        }
        if (nextPos != p) {
            double[] tmp = maxHeap[nextPos];
            maxHeap[nextPos] = maxHeap[p];
            maxHeap[p] = tmp;
            adjustHeap(maxHeap, nextPos);
        }
    }

    private double[][] buildHeap(int k) {
        double[][] heap = new double[k][2];
        for (int i = 0; i < heap.length; i++) {
            heap[i][0] = 20000;
        }
        return heap;
    }

    public static void main(String[] args) {
        Number973 number973 = new Number973();
        System.out.println(JSON.toJSONString(number973.kClosest(InputUtil.readIntArray("[[1,3],[-2,2]]"), 1)));
        System.out.println(JSON.toJSONString(number973.kClosest(InputUtil.readIntArray("[[3,3],[5,-1],[-2,4]]"), 2)));
    }
}
