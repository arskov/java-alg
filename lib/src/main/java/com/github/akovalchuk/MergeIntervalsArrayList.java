package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Educative.io. Merge an Array With Overlapping Intervals
 */
public class MergeIntervalsArrayList {

    static class Pair {
        public int first;
        public int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static ArrayList<Pair> mergeIntervals(List<Pair> v) {
        if (v == null || v.size() == 0)
            return new ArrayList<>();
        ArrayList<Pair> result = new ArrayList<>();
        result.add(v.get(0));
        for (int i = 1; i < v.size(); i++) {
            Pair curr = v.get(i);
            Pair prev = result.get(result.size() - 1);
            if (prev.first < curr.first && curr.first <= prev.second) {
                prev.second = curr.second;
            } else {
                result.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var test = List.of(
            new Pair(1, 5), new Pair(3, 7), new Pair(4, 6), new Pair(6, 8), new Pair(10, 12), new Pair(12, 15)
        );
        System.out.println(mergeIntervals(test));
    }
}
