package com.github.akovalchuk;

import java.util.ArrayList;

/**
 * Leetcode. 296. Best Meeting Point
 */
public class BestMeetingPoint {
    
    public int minTotalDistanceMNMN(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        var points = new ArrayList<int[]>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) points.add(new int[] {i, j});
            }
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dist = 0;
                for (int[] point : points) {
                    dist += Math.abs(point[0] - i) + Math.abs(point[1] - j);
                }
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        var sol = new BestMeetingPoint();
        int[][] test = {
            {1,0,0,0,1},
            {0,0,0,0,0},
            {0,0,1,0,0}
        };
        System.out.println(sol.minTotalDistanceMNMN(test));
    }
}
