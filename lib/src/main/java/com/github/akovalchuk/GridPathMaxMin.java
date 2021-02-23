package com.github.akovalchuk;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1102. Path With Maximum Minimum Value
 */
public class GridPathMaxMin {

    private static int[][] dirs = {
        { 1,  0},
        { 0,  1},
        {-1,  0},
        { 0, -1}
    };
    
    private int rows;
    private int cols;
    
    public int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        rows = A.length;
        cols = A[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] a : dist) Arrays.fill(a, Integer.MIN_VALUE);
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[2], a[2]));
        dist[0][0] = A[0][0];
        pq.offer(new int[]{0,0,A[0][0]});
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
                if (nc < 0 || nc == cols || nr < 0 || nr == rows) continue;
                int pathMin = Math.min(dist[r][c], A[nr][nc]);
                if (pathMin > dist[nr][nc]) {
                    dist[nr][nc] = pathMin;
                    pq.offer(new int[]{nr,nc,A[nr][nc]});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var sol = new GridPathMaxMin();
        int[][] test1 = {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        System.out.println(sol.maximumMinimumPath(test1)); // expected 3
        int[][] test2 = {{5,4,5},{1,2,6},{7,4,6}};
        System.out.println(sol.maximumMinimumPath(test2)); // expected 4
    }
    
}
