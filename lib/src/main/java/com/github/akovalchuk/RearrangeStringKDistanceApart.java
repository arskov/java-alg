package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Rearrange String K Distance Apart (hard)
 * 
 * Leetcode. 358. Rearrange String k Distance Apart
 */
public class RearrangeStringKDistanceApart {
    
    public static String reorganizeString(String str, int k) {
        if (str == null || str.isEmpty())
            return "";
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(counter.entrySet());
        StringBuilder buf = new StringBuilder();
        LinkedList<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            buf.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            queue.offer(entry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> tmp = queue.poll();
                if (tmp.getValue() > 0) maxHeap.offer(tmp);
            }
        }
        return buf.length() == str.length() ? buf.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aaabc", 2));
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aa", 2));
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
