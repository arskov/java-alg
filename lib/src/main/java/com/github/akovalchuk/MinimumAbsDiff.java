package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode. 1200. Minimum Absolute Difference
 */
public class MinimumAbsDiff {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length <= 1)
            return Collections.emptyList();
        Arrays.sort(arr);
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDist = Math.min(minDist, Math.abs(arr[i] - arr[i - 1]));
        }
        var result = new ArrayList<List<Integer>>();
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == minDist) {
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
        System.out.println(minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 }));
        System.out.println(minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));
        System.out.println(minimumAbsDifference(new int[] { 4, 2, 1, 3 }));
    }
}
