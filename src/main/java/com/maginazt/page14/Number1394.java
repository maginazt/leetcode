package com.maginazt.page14;

import org.junit.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaotao
 * @date: 2020/12/3 15:26
 */
public class Number1394 {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.merge(i, 1, Integer::sum);
        }
        return countMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .filter(entry -> entry.getKey().equals(entry.getValue()))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public static void main(String[] args) {
        Number1394 number1394 = new Number1394();
        Assert.assertEquals(3, number1394.findLucky(new int[]{1, 2, 2, 3, 3, 3}));
    }
}
