package com.maginazt.page10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhaotao
 * @date: 2020/12/1 11:22
 */
public class RecentCounter {

    private int start;
    private LinkedList<Integer> nums;

    public RecentCounter() {
        nums = new LinkedList<>();
    }

    public int ping(int t) {
        start = t - 3000;
        nums.addLast(t);
        nums.removeIf(num -> num < start);
        return nums.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        List<Integer> input = Arrays.asList(1, 100, 3001, 3002);
        for (Integer t : input) {
            System.out.println(recentCounter.ping(t));
        }
    }
}
