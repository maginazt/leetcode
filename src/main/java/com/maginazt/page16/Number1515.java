package com.maginazt.page16;

import org.junit.Assert;

/**
 * @author: zhaotao
 * @date: 2020/11/25 15:59
 */
public class Number1515 {

    private static final double delta = 0.0000001;

    public double getMinDistSum(int[][] positions) {
        if (positions.length == 1) {
            return 0;
        }
        int size = positions.length;
        double px = 0;
        double py = 0;
        for (int i = 0; i < positions.length; i++) {
            px += positions[i][0];
            py += positions[i][1];
        }
        px /= size;
        py /= size;
        double[] common = new double[positions.length];
        outer:
        while (true) {
            double down = 0;
            for (int i = 0; i < positions.length; i++) {
                common[i] = 1 / getDistance(px, py, positions[i][0], positions[i][1]);
                if (common[i] == Double.POSITIVE_INFINITY) {
                    break outer;
                }
                down += common[i];
            }
            double pxn = 0.0;
            double pyn = 0.0;
            for (int i = 0; i < positions.length; i++) {
                pxn += positions[i][0] * common[i] / down;
                pyn += positions[i][1] * common[i] / down;
            }
            if (Math.abs(pxn - px) < delta && Math.abs(pyn - py) < delta) {
                break;
            }
            px = pxn;
            py = pyn;
        }
        double distance = 0;
        for (int i = 0; i < positions.length; i++) {
            distance += getDistance(px, py, positions[i][0], positions[i][1]);
        }
        return distance;
    }

    private double getDistance(double px, double py, double qx, double qy) {
        return Math.sqrt((px - qx) * (px - qx) + (py - qy) * (py - qy));
    }

    public static void main(String[] args) {
        Number1515 number1515 = new Number1515();
        double e = 0.00001;
        Assert.assertEquals(1119.58582, number1515.getMinDistSum(new int[][]{{4,4},{52,89},{76,60},{4,4},{4,4},{93,59},{50,92},{4,4},{76,14},{4,4},{46,41},{4,4},{4,4},{4,4},{4,4},{67,14},{73,71},{83,44},{4,4},{4,4},{4,4},{4,4},{30,29},{74,77},{4,4},{4,4},{4,4},{26,62},{4,4},{4,4},{50,30},{44,93}}), e);
        Assert.assertEquals(4.00000, number1515.getMinDistSum(new int[][]{{0, 1}, {1, 0}, {1, 2}, {2, 1}}), e);
        Assert.assertEquals(2.82843, number1515.getMinDistSum(new int[][]{{1, 1}, {3, 3}}), e);
        Assert.assertEquals(0.00000, number1515.getMinDistSum(new int[][]{{1, 1}}), e);
        Assert.assertEquals(2.73205, number1515.getMinDistSum(new int[][]{{1, 1}, {0, 0}, {2, 0}}), e);
        Assert.assertEquals(32.94036, number1515.getMinDistSum(new int[][]{{0, 1}, {3, 2}, {4, 5}, {7, 6}, {8, 9}, {11, 1}, {2, 12}}), e);
        Assert.assertEquals(4.00000, number1515.getMinDistSum(new int[][]{{0, 1}, {1, 0}, {1, 2}, {2, 1}, {1, 1}}), e);
    }
}
