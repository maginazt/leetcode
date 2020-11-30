package com.maginazt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @author: zhaotao
 * @date: 2020/11/25 18:20
 */
public class InputUtil {

    public static int[][] readIntArray(String json) {
        JSONArray jsonArray = JSON.parseArray(json);
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JSONArray array = jsonArray.getJSONArray(i);
            arr[i] = toArray(array);
        }
        return arr;
    }

    private static int[] toArray(JSONArray jsonArray) {
        int[] arr = new int[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.getIntValue(i);
        }
        return arr;
    }
}
