package com.maginazt.page14;

import com.maginazt.util.InputUtil;

/**
 * @author: zhaotao
 * @date: 2020/12/2 11:08
 */
public class Number1377 {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[][] graph = init(n, edges);
        Double result = calculateProb(graph, t, target, 0, 1, 1.0);
        return result == null ? 0 : result;
    }

    private Double calculateProb(int[][] graph, int t, int target, int time, int vertex, double probability) {
        if (target == vertex) {
            if (time == t) {
                return probability;
            } else if (t < time) {
                return 0.0;
            } else {
                return graph[vertex][vertex] > 0 ? 0.0 : probability;
            }
        }
        for (int child = vertex + 1; child < graph[0].length; child++) {
            if (graph[vertex][child] == 0 || graph[child][vertex] != 0) {
                continue;
            }
            Double subResult = calculateProb(graph, t, target, time + 1, child, probability / graph[vertex][vertex]);
            if (subResult != null) {
                return subResult;
            }
            graph[child][vertex] = 1;
        }
        return null;
    }

    private int[][] init(int n, int[][] edges) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            int from = Math.min(edge[0], edge[1]);
            int to = Math.max(edge[0], edge[1]);
            graph[from][to] = 1;
            ++graph[from][from];
        }
        return graph;
    }

    public static void main(String[] args) {
        Number1377 number1377 = new Number1377();
        System.out.println(number1377.frogPosition(7, InputUtil.readIntArray("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]"), 2, 4));
        System.out.println(number1377.frogPosition(7, InputUtil.readIntArray("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]"), 1, 7));
        System.out.println(number1377.frogPosition(7, InputUtil.readIntArray("[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]"), 20, 6));
    }
}
