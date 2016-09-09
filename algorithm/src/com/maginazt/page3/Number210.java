package com.maginazt.page3;

import java.util.*;

/**
 * Created by zhaotao on 2016/9/8.
 */
public class Number210 {

    public static final int WHITE = 0;
    public static final int GREY = 1;
    public static final int BLACK = 2;

    private static int[] colors;
    private static Map<Integer, List<Integer>> edges = new HashMap<>();
    private static int[] order;
    private static int pos;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        colors = new int[numCourses];
        order = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i=0;i<numCourses;i++)
                order[i] = i;
            return order;
        }
        edges.clear();
        pos = numCourses-1;
        for(int[] edge : prerequisites){
            if(edges.containsKey(edge[1]))
                edges.get(edge[1]).add(edge[0]);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                edges.put(edge[1], list);
            }
        }
        boolean canFinish = true;
        for(int v=0;v<numCourses;v++)
            if(colors[v] == WHITE){
                if(!dfs(v)){
                    canFinish = false;
                    break;
                }
            }
        if(!canFinish)
            return new int[0];
        else
            return order;
    }

    private boolean dfs(int v) {
        colors[v] = GREY;
        if(edges.containsKey(v)){
            List<Integer> es = edges.get(v);
            for(int u : es){
                if(colors[u] == WHITE){
                    if(!dfs(u))
                        return false;
                }
                else if(colors[u] == GREY)
                    return false;
            }
        }
        colors[v] = BLACK;
        order[pos--] = v;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Number210().findOrder(2, new int[][]{{0,1}})));
    }
}
