package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Frequency Sort (medium)
 * 451. Sort Characters By Frequency
 * 
 * Note: This is not very optimal solution. There is a Multiset and Bucket Sort approach with O(N)
 */
public class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        if (str == null || str.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            // if (a.getValue().equals(b.getValue())) {
            // return a.getKey() - b.getKey();
            // } else {
            return b.getValue() - a.getValue();
            // }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        StringBuilder tmp = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                tmp.append(entry.getKey());
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }

}
