package com.maginazt.page2;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class Number167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = numbers.length-1;
        while (true){
            int sum = numbers[low] + numbers[high];
            if(sum == target)
                break;
            else if(sum < target)
                ++low;
            else
                --high;
        }
        result[0] = low+1;
        result[1] = high+1;
        return result;
    }

    public static void main(String[] args) {

    }
}
