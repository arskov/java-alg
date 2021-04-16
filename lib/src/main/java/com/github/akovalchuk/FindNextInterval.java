package com.github.akovalchuk;

import java.util.Map;
import java.util.TreeMap;


/**
 * Educative.io. Next Interval (hard)
 */
public class FindNextInterval {

    public static class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Interval, Integer> indexMap = new TreeMap<>((a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Interval curr = intervals[i];
            Map.Entry<Interval, Integer> next = indexMap.ceilingEntry(new Interval(curr.end, 0));
            if (next == null) {
                result[i] = -1;
            } else {
                result[i] = next.getValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();
    }
}
