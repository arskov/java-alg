package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Leetcode. 986. Interval List Intersections
 */
public class MergeIntervals {

    private static final int[][] EMPTY = new int[0][];

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null) return EMPTY;
        if (firstList.length == 0) return EMPTY;
        if (secondList.length == 0) return EMPTY;
        var queue = new ArrayDeque<int[]>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] f = firstList[i];
            int[] s = secondList[i];
            int a = Math.max(f[0], s[0]);
            int b = Math.min(f[1], s[1]);
            if (a <= b) {
                queue.add(new int[] {a, b});
            }
            if (f[1] < s[1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[queue.size()][];
        return queue.toArray(res);
    }

    public static void main(String[] args) {
        var solution = new MergeIntervals();
        int[][] firstList = {
            {0,2},{5,10},{13,23},{24,25}
        };
        int[][] secondList = {
            {1,5},{8,12},{15,24},{25,26}
        };
        int[][] result = solution.intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(result));
    }

}
