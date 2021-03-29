package com.github.akovalchuk;

import java.util.ArrayDeque;

/**
 * Leetcode. 695. Max Area of Island
 */
public class MaxAreaOfIsland {

    private static int max = 0;
    
    private static int[][] directions = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1 && grid[i][j] != 0) {
                    bfs(grid, i, j);
                }
            }
        }
        return max;
    }
    
    private static void bfs(int[][] grid, int i, int j) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[] {i, j});
        grid[i][j] = -1;
        int current = 0;
        while (!queue.isEmpty()) {
            var pair = queue.poll();
            current++;
            for (var dir : directions) {
                int r = pair[0] + dir[0];
                int c = pair[1] + dir[1];
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;
                if (grid[r][c] == -1 || grid[r][c] == 0) continue;
                grid[r][c] = -1;
                queue.offer(new int[]{r, c});
            }
        }
        max = Math.max(max, current);
    }
    
    public static void main(String[] args) {
        int[][] test1 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };

        System.out.println(maxAreaOfIsland(test1));

        int[][] test2 = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1},
        };

        System.out.println(maxAreaOfIsland(test2));
    }
}
