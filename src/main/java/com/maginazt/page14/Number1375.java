package com.maginazt.page14;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author: zhaotao
 * @date: 2020/11/24 16:52
 */
public class Number1375 {

    public int numTimesAllBlue(int[] light) {
        if (light.length <= 64) {
            long bitmap = 0;
            int result = 0;
            for (int i = 0; i < light.length; i++) {
                bitmap |= 1L << (light[i] - 1);
                if ((bitmap & (bitmap + 1)) == 0) {
                    ++result;
                }
            }
            return result;
        } else {
            long[] bitmap = new long[light.length / 64 + (light.length % 64 != 0 ? 1 : 0)];
            int result = 0;
            for (int i = 0; i < light.length; i++) {
                int index = (light[i] - 1) / 64;
                int remain = (light[i] - 1) % 64;
                bitmap[index] |= 1L << remain;
                if (isAllOneRight(bitmap)) {
                    ++result;
                }
            }
            return result;
        }
    }

    private boolean isAllOneRight(long[] bitmap) {
        int i = bitmap.length - 1;
        //定位首个非0的位置
        while (i >= 0) {
            if (bitmap[i] != 0) {
                break;
            }
            --i;
        }
        if (i < 0) {
            return false;
        }
        if ((bitmap[i] & (bitmap[i] + 1)) != 0) {
            return false;
        }
        //之后必须都为-1
        --i;
        while (i >= 0) {
            if (bitmap[i] != -1) {
                return false;
            }
            --i;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Number1375 number1375 = new Number1375();
        int[] numbers = readNumbers();
        Assert.assertEquals(1, number1375.numTimesAllBlue(numbers));
        Assert.assertEquals(5, number1375.numTimesAllBlue(new int[]{1, 2, 29, 4, 5, 6, 7, 8, 9, 23, 11, 66, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 10, 24, 60, 26, 27, 28, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 83, 53, 81, 55, 56, 57, 58, 59, 62, 61, 25, 63, 64, 65, 12, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 54, 82, 52, 84, 85}));
        Assert.assertEquals(9, number1375.numTimesAllBlue(new int[]{1, 2, 44, 4, 5, 6, 32, 8, 9, 10, 3, 50, 13, 33, 45, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 7, 14, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 11, 15, 46, 47, 48, 12, 49, 51, 52, 53, 54, 55, 56}));
        Assert.assertEquals(3, number1375.numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
        Assert.assertEquals(2, number1375.numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        Assert.assertEquals(1, number1375.numTimesAllBlue(new int[]{4, 1, 2, 3}));
        Assert.assertEquals(3, number1375.numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
        Assert.assertEquals(6, number1375.numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static int[] readNumbers() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/zhaotao/Downloads/testcase.txt"));
        String line = bufferedReader.readLine();
        JSONArray jsonArray = JSON.parseArray(line);
        int[] nums = new int[jsonArray.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = jsonArray.getIntValue(i);
        }
        return nums;
    }
}
