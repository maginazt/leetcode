package com.maginazt.common;

/**
 * Created by zhaotao on 2019/2/24.
 */
public class AssertUtil {

    public static void assertTrue(boolean result) {
        if (!result) {
            throw new RuntimeException("assert error");
        }
    }
}
