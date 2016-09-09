package com.maginazt.page3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaotao on 2016/9/7.
 */
public class Number207 {

//    public static final int WHITE = 0;
//    public static final int GREY = 1;
//    public static final int BLACK = 2;
//
//    private static int[] colors;
//    private static int[][] graph;
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        colors = new int[numCourses];
//        graph = new int[numCourses][numCourses];
//        for(int[] edge : prerequisites)
//            graph[edge[1]][edge[0]] = 1;
//        boolean result = true;
//        for(int v=0;v<numCourses;v++)
//            if(colors[v] == WHITE){
//                if(!dfs(v)){
//                    result = false;
//                    break;
//                }
//            }
//        return result;
//    }
//
//    private boolean dfs(int v) {
//        colors[v] = GREY;
//        for(int u=0;u<colors.length;u++){
//            if(u != v && graph[v][u] == 1){
//                if(colors[u] == WHITE){
//                    if(!dfs(u))
//                        return false;
//                }
//                else if(colors[u] == GREY)
//                    return false;
//            }
//        }
//        colors[v] = BLACK;
//        return true;
//    }

    private static final Map<Integer, Integer> indegreeMap = new HashMap<>();
    private static final Set<Integer> zeroIndegreeSet = new HashSet<>();
    private static int[][] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegreeMap.clear();
        zeroIndegreeSet.clear();
        graph = new int[numCourses][numCourses];
        for(int i=0;i<numCourses;i++)
            zeroIndegreeSet.add(i);
        for(int[] edge : prerequisites){
            if(graph[edge[1]][edge[0]] != 1){
                graph[edge[1]][edge[0]] = 1;
                zeroIndegreeSet.remove(edge[0]);
                if(indegreeMap.containsKey(edge[0]))
                    indegreeMap.put(edge[0], indegreeMap.get(edge[0])+1);
                else
                    indegreeMap.put(edge[0], 1);
            }
        }
        while (!zeroIndegreeSet.isEmpty()){
            int v = zeroIndegreeSet.iterator().next();
            zeroIndegreeSet.remove(v);
            for(int u=0;u<numCourses;u++){
                if(u != v && graph[v][u] == 1){
                    int indegree = indegreeMap.get(u);
                    if(indegree == 1){
                        indegreeMap.remove(u);
                        zeroIndegreeSet.add(u);
                    }
                    else
                        indegreeMap.put(u, indegree-1);
                }
            }
        }
        return indegreeMap.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Number207().canFinish(10, new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}}));
    }
}
