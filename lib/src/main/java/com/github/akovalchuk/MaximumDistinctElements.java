package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Maximum Distinct Elements (medium)
 * 
 * 1481. Least Number of Unique Integers after K Removals (Similar but a kind of reversed)
 */
public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        int diffCount = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                diffCount++;
            } else {
                pq.offer(entry);
            }
        }
        while (!pq.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            k -= entry.getValue() - 1;
            if (k >= 0) diffCount++;
        }
        diffCount -= (k > 0 ? k : 0);
        return diffCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
