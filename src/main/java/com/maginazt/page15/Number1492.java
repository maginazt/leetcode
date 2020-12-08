package com.maginazt.page15;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaotao
 * @date: 2020/12/7 16:32
 */
public class Number1492 {

    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            int o = n / i;
            if (o * i == n) {
                factors.add(i);
                if (factors.size() == k) {
                    return i;
                }
            }
        }
        int beginIndex = (factors.get(factors.size() - 1) * factors.get(factors.size() - 1) == n) ? factors.size() - 2 : factors.size() - 1;
        int factorsSoFar = factors.size();
        for (int i = beginIndex; i >= 0; i--) {
            ++factorsSoFar;
            if (factorsSoFar == k) {
                return n / factors.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Number1492 number1492 = new Number1492();
        Assert.assertEquals(2, number1492.kthFactor(2, 2));
        Assert.assertEquals(3, number1492.kthFactor(12, 3));
        Assert.assertEquals(7, number1492.kthFactor(7, 2));
        Assert.assertEquals(-1, number1492.kthFactor(4, 4));
        Assert.assertEquals(1, number1492.kthFactor(1, 1));
        Assert.assertEquals(4, number1492.kthFactor(1000, 3));
    }
}
