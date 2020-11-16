package com.maginazt.page3;

/**
 * Created by zhaotao on 2016/10/10.
 */
public class MedianFinder {

    //是否要在最小堆中添加数据
    private boolean isRight;
    //最大堆：保存有序数列前一半元素
    private int[] maxHeap = new int[0];
    //最大堆大小
    private int maxHeapSize;
    //最小堆：保存有序数列后一半元素
    private int[] minHeap = new int[0];
    //最小堆大小
    private int minHeapSize;

    // Adds a number into the data structure.
    public void addNum(int num) {
        //需要在最小堆中添加下一个元素
        if(isRight){
            //此时最大堆一定存在
            //若下一个元素事实上位于前一半，则将其与最大堆堆顶元素进行替换
            if(num < maxHeap[0]){
                int tmp = num;
                num = maxHeap[0];
                maxHeap[0] = tmp;
                //自顶向下保持最大堆性质
                maxHeapify(0);
            }
            //将新元素添加至最小堆的末尾，并保持最小堆性质
            addToMinHeap(num);
        }
        //在最大堆中添加下一个元素
        else{
            //此时最小堆一定存在
            //若下一个元素事实上位于后一半，则将其与最小堆堆顶元素进行替换
            if(maxHeapSize > 0 && num > minHeap[0]){
                int tmp = num;
                num = minHeap[0];
                minHeap[0] = tmp;
                //自顶向下保持最小堆性质
                minHeapify(0);
            }
            //将新元素添加至最大堆的末尾，并保持最大堆性质
            addToMaxHeap(num);
        }
        isRight = !isRight;
    }

    private void addToMaxHeap(int num) {
        //full
        if(maxHeapSize == maxHeap.length){
            int[] newHeap = new int[2*maxHeapSize+1];
            System.arraycopy(maxHeap, 0, newHeap, 0, maxHeapSize);
            maxHeap = newHeap;
        }
        maxHeap[maxHeapSize] = num;
        int c = maxHeapSize;
        int p = (c-1)/2;
        while (p != c && maxHeap[c] > maxHeap[p]){
            int tmp = maxHeap[c];
            maxHeap[c] = maxHeap[p];
            maxHeap[p] = tmp;
            c = p;
            p = (c-1)/2;
        }
        ++maxHeapSize;
    }

    private void addToMinHeap(int num) {
        //full,再次扩容
        if(minHeapSize == minHeap.length){
            int[] newHeap = new int[2*minHeapSize+1];
            System.arraycopy(minHeap, 0, newHeap, 0, minHeapSize);
            minHeap = newHeap;
        }
        minHeap[minHeapSize] = num;
        int c = minHeapSize;
        int p = (c-1)/2;
        while (p != c && minHeap[c] < minHeap[p]){
            int tmp = minHeap[c];
            minHeap[c] = minHeap[p];
            minHeap[p] = tmp;
            c = p;
            p = (c-1)/2;
        }
        ++minHeapSize;
    }

    private void minHeapify(int p) {
        int leftChild = 2*p+1;
        int rightChild = 2*p+2;
        int minest;
        if(leftChild < minHeapSize && minHeap[leftChild] < minHeap[p])
            minest = leftChild;
        else
            minest = p;
        if(rightChild < minHeapSize && minHeap[rightChild] < minHeap[minest])
            minest = rightChild;
        if(minest != p){
            int tmp = minHeap[minest];
            minHeap[minest] = minHeap[p];
            minHeap[p] = tmp;
            minHeapify(minest);
        }
    }

    private void maxHeapify(int p) {
        int leftChild = 2*p+1;
        int rightChild = 2*p+2;
        int largest;
        if(leftChild < maxHeapSize && maxHeap[leftChild] > maxHeap[p])
            largest = leftChild;
        else
            largest = p;
        if(rightChild < maxHeapSize && maxHeap[rightChild] > maxHeap[largest])
            largest = rightChild;
        if(largest != p){
            int tmp = maxHeap[largest];
            maxHeap[largest] = maxHeap[p];
            maxHeap[p] = tmp;
            maxHeapify(largest);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeapSize == minHeapSize)
            return (maxHeap[0]+minHeap[0]) / 2.0;
        else
            return maxHeap[0];
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(40);mf.findMedian();mf.addNum(12);mf.findMedian();mf.addNum(16);mf.findMedian();mf.addNum(14);
        mf.findMedian();mf.addNum(35);mf.findMedian();mf.addNum(19);mf.findMedian();mf.addNum(34);mf.findMedian();mf.addNum(35);mf.findMedian();mf.addNum(28);mf.findMedian();mf.addNum(35);mf.findMedian();mf.addNum(26);mf.findMedian();mf.addNum(6);mf.findMedian();mf.addNum(8);mf.findMedian();mf.addNum(2);mf.findMedian();mf.addNum(14);
        mf.findMedian();mf.addNum(25);mf.findMedian();mf.addNum(25);mf.findMedian();mf.addNum(4);mf.findMedian();mf.addNum(33);mf.findMedian();mf.addNum(18);mf.findMedian();mf.addNum(10);mf.findMedian();mf.addNum(14);
        mf.findMedian();mf.addNum(27);mf.findMedian();mf.addNum(3);mf.findMedian();mf.addNum(35);mf.findMedian();mf.addNum(13);mf.findMedian();mf.addNum(24);mf.findMedian();mf.addNum(27);mf.findMedian();mf.addNum(14);
        mf.findMedian();mf.addNum(5);mf.findMedian();mf.addNum(0);mf.findMedian();mf.addNum(38);mf.findMedian();mf.addNum(19);mf.findMedian();mf.addNum(25);mf.findMedian();mf.addNum(11);mf.findMedian();mf.addNum(14);
        mf.findMedian();mf.addNum(31);mf.findMedian();mf.addNum(30);mf.findMedian();mf.addNum(11);mf.findMedian();mf.addNum(31);mf.findMedian();mf.addNum(0);mf.findMedian();
//        mf.addNum(-1);
//        mf.addNum(-2);
//        mf.addNum(-3);
//        mf.addNum(-4);
//        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }
}
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();