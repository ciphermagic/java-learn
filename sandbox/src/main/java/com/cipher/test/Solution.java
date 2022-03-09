package com.cipher.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, Integer> areaMap = new HashMap<>();
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public int largestIsland(int[][] grid) {
        int res = 0;
        int index = 2;
        boolean hasIsland = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    areaMap.put(index, curArea(grid, i, j, index));
                    index++;
                    hasIsland = true;
                }
            }
        }
        if (!hasIsland) {
            return 1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, newArea(grid, i, j));
                }
            }
        }
        return res;
    }

    private int curArea(int[][] grid, int i, int j, int index) {
        if (!inArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int res = 1;
        for (int[] dir : dirs) {
            res += curArea(grid, i + dir[0], j + dir[1], index);
        }
        return res;
    }

    private int newArea(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int[] dir : dirs) {
            int ti = i + dir[0];
            int tj = j + dir[1];
            if (inArea(grid, ti, tj) && grid[ti][tj] != 0 && !set.contains(grid[ti][tj])) {
                res += areaMap.get(grid[ti][tj]);
                set.add(grid[ti][tj]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.largestIsland(new int[][]{{1, 1}, {1, 1}});
        System.out.println();
    }
}