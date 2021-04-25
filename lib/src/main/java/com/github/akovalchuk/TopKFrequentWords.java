package com.github.akovalchuk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode. 692. Top K Frequent Words
 */
public class TopKFrequentWords {

    private static final Comparator<Map.Entry<String, Integer>> comp = (a, b) -> {
        if (a.getValue().equals(b.getValue())) {
            return b.getKey().compareTo(a.getKey());
        }
        return a.getValue() - b.getValue();
    };

    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0)
            return List.of();
        var map = new HashMap<String, Integer>();
        for (var w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        var pq = new PriorityQueue<Map.Entry<String, Integer>>(comp);
        for (var entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        var result = new LinkedList<String>();
        while (!pq.isEmpty())
            result.addFirst(pq.poll().getKey());
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> result = topKFrequent(test, 4);
        System.out.println("Here are the K frequent numbers: " + result);

    }
}
