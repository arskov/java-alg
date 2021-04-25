package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

/**
 * Educative.io. Top 'K' Frequent Numbers (medium)
 * 
 * Leetcode. 347. Top K Frequent Elements
 * Leetcode. 692. Top K Frequent Words
 */
public class TopKFrequentNumbers {

    private static final Comparator<Map.Entry<Integer, Integer>> comp = (a, b) -> {
        if (a.getValue().equals(b.getValue())) {
            return a.getKey()- b.getKey();
        }
        return a.getValue() - b.getValue();
    };

    private static final BiFunction<Integer, Integer, Integer> inc = (k, v) -> v == null ? 1 : v + 1;

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.compute(n, inc);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }
        for (int i = 0; i < k; i++)
            topNumbers.add(pq.poll().getKey());
        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }

}
