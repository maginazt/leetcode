package com.maginazt.page5;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/12/3 09:32
 */
public class Number492 {

    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i <= area; i++) {
            int y = area / i;
            if (i * y == area) {
                return new int[]{Math.max(i, y), Math.min(i, y)};
            }
        }
        return new int[]{area, 1};
    }

    public static void main(String[] args) {
        Number492 number492 = new Number492();
        System.out.println(Arrays.toString(number492.constructRectangle(2)));
        System.out.println(Arrays.toString(number492.constructRectangle(122122)));
        System.out.println(Arrays.toString(number492.constructRectangle(4)));
        System.out.println(Arrays.toString(number492.constructRectangle(37)));
    }
}
