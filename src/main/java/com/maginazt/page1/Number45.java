package com.maginazt.page1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Number45 {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int position = 0;
        int step = 0;
        while (position < nums.length) {
            List<? super Number> list = new ArrayList<>();
            Serializable b = 0.1;
            list.add(1);
            list.add(2.9);
            list.add(null);
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Number45().jump(new int[]{2, 3, 0, 0, 4}));
    }
}
