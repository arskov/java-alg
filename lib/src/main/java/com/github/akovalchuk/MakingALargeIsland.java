package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Leetcode. 827. Making A Large Island
 * 
 * [0,0,0,0,0,0,0]
 * [0,1,1,1,1,0,0]
 * [0,1,0,0,1,0,0]
 * [1,0,1,0,1,0,0]
 * [0,1,0,0,1,0,0]
 * [0,1,0,0,1,0,0]
 * [0,1,1,1,1,0,0]
 * 
 */
public class MakingALargeIsland {
    private static final int[][] DIRS = {
        {-1,  0},
        { 0, -1},
        { 1,  0},
        { 0,  1}
    };
    
    private static final int[][] DIR_PAIRS = {
        { 0,-1}, {-1, 0}, 
        { 0,-1}, { 0, 1}, 
        { 0,-1}, { 1, 0},
        {-1, 0}, { 0, 1},
        {-1, 0}, { 1, 0},
        { 1, 0}, { 1, 0}
    };
    
    private int rows;
    private int cols;
    
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        var compSize = new HashMap<Integer, Integer>();
        int component = 1;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    component++;
                    int size = bfs(grid, i, j, component);
                    compSize.put(component, size);
                    max = Math.max(max, size);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    var components = new HashSet<Integer>();
                    for (int k = 0; k < DIR_PAIRS.length; k += 2) {
                        int r1 = i + DIR_PAIRS[k][0];
                        int c1 = j + DIR_PAIRS[k][1];
                        int r2 = i + DIR_PAIRS[k + 1][0];
                        int c2 = j + DIR_PAIRS[k + 1][1];
                        if (r1 < 0 || r1 >= rows || c1 < 0 || c1 >= cols || grid[r1][c1] == 0) continue;
                        if (r2 < 0 || r2 >= rows || c2 < 0 || c2 >= cols || grid[r2][c2] == 0) continue;
                        if (grid[r1][c1] != grid[r2][c2]) {
                            components.add(grid[r1][c1]);
                            components.add(grid[r2][c2]);
                        }
                    }
                    for (var comp : components) {
                        sum += compSize.get(comp);
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return ((max == rows * cols) ? max : max + 1);
    }
    
    private int bfs(int[][] grid, int i, int j, int component) {
        int size = 1;
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {i, j});
        grid[i][j] = component;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : DIRS) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || grid[r][c] == component) continue;
                grid[r][c] = component;
                size++;
                queue.add(new int[] {r, c});
            }
        }
        return size;
    } 

    public static void main(String[] args) {
        var mat = new MakingALargeIsland();
        int[][] grid = {
            {0,0,0,0,0,0,0},
            {0,1,1,1,1,0,0},
            {0,1,0,0,1,0,0},
            {1,0,1,0,1,0,0},
            {0,1,0,0,1,0,0},
            {0,1,0,0,1,0,0},
            {0,1,1,1,1,0,0}
        };
        System.out.println(mat.largestIsland(grid)); // expected 18
    }
}
