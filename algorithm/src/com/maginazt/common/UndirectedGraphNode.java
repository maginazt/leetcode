package com.maginazt.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaotao on 2016/8/27.
 */
public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
