package com.github.akovalchuk;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1631. Path With Minimum Effort
 */
public class GridMinEffort {

    private static int[][] dirs = new int[][] {
        { 0,  1}, 
        { 1,  0},
        { 0, -1},
        {-1,  0}
    };

    private int rows;
    private int cols;
    private int min;

    public int minimumEffortPathBacktrack(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return 0;
        rows = heights.length;
        cols = heights[0].length;
        min = Integer.MAX_VALUE;
        dfs(heights, 0, 0, 0);
        return min;
    }

    private int dfs(int[][] heights, int r, int c, int maxEffort) {
        if (r == rows - 1 && c == cols - 1) {
            min = Math.min(min, maxEffort); 
            return maxEffort;
        }
        int minPath = Integer.MAX_VALUE;
        int prevHeight = heights[r][c];
        heights[r][c] = 0; // visited
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr == rows || nc < 0 || nc == cols) continue;
            if (heights[nr][nc] == 0) continue;
            int diff = Math.abs(heights[nr][nc] - prevHeight);
            int newMaxEffort = Math.max(maxEffort, diff);
            if (newMaxEffort < min) {
                int result = dfs(heights, nr, nc, newMaxEffort);
                minPath = Math.min(minPath, result);
            }
        }
        heights[r][c] = prevHeight;
        return minPath;
    }

    public int minimumEffortPathDijkstra(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return 0;
        rows = heights.length;
        cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] a : dist) Arrays.fill(a, Integer.MAX_VALUE);
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] {0,0,0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == rows - 1 && c == cols - 1) {
                return dist[r][c];
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr == rows || nc < 0 || nc == cols) continue;
                int diff = Math.abs(heights[nr][nc] - heights[cur[0]][cur[1]]);
                int pathMax = Math.max(dist[r][c], diff);
                if (pathMax < dist[nr][nc]) {
                    dist[nr][nc] = pathMax;
                    pq.offer(new int[]{nr,nc,diff});
                }
            }
        }
        // for (int[] a : dist) {
        //     System.out.println(Arrays.toString(a));
        // }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new GridMinEffort();
        int[][] heights1 = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        System.out.println(sol.minimumEffortPathBacktrack(heights1));
        int[][] heights2 = {
            {1,2,3},
            {3,8,4},
            {5,3,5}
        };
        System.out.println(sol.minimumEffortPathBacktrack(heights2));

        System.out.println(sol.minimumEffortPathDijkstra(heights1));
        System.out.println(sol.minimumEffortPathDijkstra(heights2));
    }
}
