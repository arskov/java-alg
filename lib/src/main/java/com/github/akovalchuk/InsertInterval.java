package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Educative.io. Insert Interval (medium)
 */
public class InsertInterval {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        if (newInterval.start <= intervals.get(0).start) {
            mergedIntervals.addLast(newInterval);
        }
        for (Interval interval : intervals) {
            if (!mergedIntervals.isEmpty()) {
                Interval last = mergedIntervals.peekLast();
                if (newInterval != null && newInterval.start >= last.start && newInterval.start <= last.end) {
                    last.start = Math.min(last.start, newInterval.start);
                    last.end = Math.max(last.end, newInterval.end);
                    newInterval = null;
                } else if (newInterval != null && newInterval.start < interval.start) {
                    mergedIntervals.addLast(newInterval);
                    last = mergedIntervals.peekLast();
                    newInterval = null;
                }
                if (interval.start >= last.start && interval.start <= last.end) {
                    last.start = Math.min(last.start, interval.start);
                    last.end = Math.max(last.end, interval.end);
                } else {
                    mergedIntervals.addLast(interval);
                }
            } else {
                mergedIntervals.addLast(interval);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
