package com.github.akovalchuk;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Leetcode. 436. Find Right Interval
 */
public class FindRightInterval {

    private static class Holder implements Comparable<Holder> {
        int start;
        int end;
        int idx;

        Holder(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        public int compareTo(Holder other) {
            return this.start - other.start;
        }

    }

    public static int[] findRightInterval(int[][] intervals) {
        if (intervals == null)
            return new int[0];
        int[] result = new int[intervals.length];
        var ts = new TreeSet<Holder>();
        for (int i = 0; i < intervals.length; i++) {
            ts.add(new Holder(intervals[i][0], intervals[i][1], i));
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            var next = ts.ceiling(new Holder(curr[1], 0, 0));
            if (next == null) {
                result[i] = -1;
            } else {
                result[i] = next.idx;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,2}};
        System.out.println(Arrays.toString(findRightInterval(test1)));
        int[][] test2 = {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(test2)));
        int[][] test3 = {{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(test3)));
    }

}
