package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Educative.io. Employee Free Time (hard)
 */
public class EmployeeFreeTime {

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

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }
        Interval last = pq.poll();
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();
            if (last.end < curr.start) {
                result.add(new Interval(last.end, curr.start));
                last = curr;
            } else {
                last.end = curr.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();
    }
}
