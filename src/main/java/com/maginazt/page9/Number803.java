package com.maginazt.page9;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/16 15:42
 */
public class Number803 {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] convas = copy(grid);
        for (int i = 0; i < hits.length; i++) {
            convas[hits[i][0]][hits[i][1]] = 0;
        }
        int[] result = new int[hits.length];
        //并查集父指针
        int[] p = new int[grid.length * grid[0].length];
        //并查集各集合大小
        int[] sz = new int[grid.length * grid[0].length];
        //初始化并查集
        init(convas, p, sz);
        for (int i = hits.length - 1; i >= 0; i--) {
            if (grid[hits[i][0]][hits[i][1]] == 0) {
                continue;
            }
            convas[hits[i][0]][hits[i][1]] = 1;
            int index = getIndex(hits[i][0], hits[i][1], grid[0].length);
            p[index] = index;
            sz[index] = 1;
            if (getTop(convas, hits[i][0], hits[i][1]) == 1) {
                result[i] += union(index, getIndex(hits[i][0] - 1, hits[i][1], grid[0].length), p, sz, grid[0].length);
            }
            if (getDown(convas, hits[i][0], hits[i][1]) == 1) {
                result[i] += union(index, getIndex(hits[i][0] + 1, hits[i][1], grid[0].length), p, sz, grid[0].length);
            }
            if (getLeft(convas, hits[i][0], hits[i][1]) == 1) {
                result[i] += union(index, getIndex(hits[i][0], hits[i][1] - 1, grid[0].length), p, sz, grid[0].length);
            }
            if (getRight(convas, hits[i][0], hits[i][1]) == 1) {
                result[i] += union(index, getIndex(hits[i][0], hits[i][1] + 1, grid[0].length), p, sz, grid[0].length);
            }
        }
        return result;
    }

    private int[][] copy(int[][] grid) {
        int[][] convas = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                convas[i][j] = grid[i][j];
            }
        }
        return convas;
    }

    private void init(int[][] grid, int[] p, int[] sz) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int index = getIndex(i, j, grid[0].length);
                p[index] = index;
                sz[index] = 1;
                if (getLeft(grid, i, j) == 1) {
                    union(index, getIndex(i, j - 1, grid[0].length), p, sz, grid[0].length);
                }
                if (getTop(grid, i, j) == 1) {
                    union(index, getIndex(i - 1, j, grid[0].length), p, sz, grid[0].length);
                }
            }
        }
    }

    private int find(int i, int[] p) {
        if (p[i] == i) {
            return i;
        } else {
            return (p[i] = find(p[i], p));
        }
    }

    private int union(int pivitol, int i2, int[] p, int[] sz, int length) {
        int p1 = find(pivitol, p);
        int p2 = find(i2, p);
        if (p1 == p2) {
            return 0;
        }
        if (p1 < length) {
            p[p2] = p1;
            sz[p1] += sz[p2];
            return p2 < length ? 0 : sz[p2];
        } else {
            p[p1] = p2;
            sz[p2] += sz[p1];
            return p2 < length ? sz[p1] - 1 : 0;
        }
    }

    private int getLeft(int[][] grid, int i, int j) {
        if (j == 0) {
            return 0;
        }
        return grid[i][j - 1];
    }

    private int getRight(int[][] grid, int i, int j) {
        if (j == grid[0].length - 1) {
            return 0;
        }
        return grid[i][j + 1];
    }

    private int getTop(int[][] grid, int i, int j) {
        if (i == 0) {
            return 0;
        }
        return grid[i - 1][j];
    }

    private int getDown(int[][] grid, int i, int j) {
        if (i == grid.length - 1) {
            return 0;
        }
        return grid[i + 1][j];
    }

    private int getIndex(int i, int j, int length) {
        return i * length + j;
    }

    public static void main(String[] args) {
        Number803 number803 = new Number803();
        assert Arrays.equals(new int[]{2}, number803.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}}));
        assert Arrays.equals(new int[]{0, 0}, number803.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}}));
        assert Arrays.equals(new int[]{4, 2, 3}, number803.hitBricks(new int[][]{{1, 0, 0, 1, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 0, 1}}, new int[][]{{0, 3}, {1, 0}, {0, 6}}));
        assert Arrays.equals(new int[]{0, 0, 1, 0}, number803.hitBricks(new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}, new int[][]{{0, 2}, {2, 0}, {0, 1}, {1, 2}}));
    }
}
