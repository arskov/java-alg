package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Rearrange String (hard)
 * 
 * Leetcode. 767. Reorganize String
 */
public class RearrangeString {

    public static String rearrangeString(String str) {
        if (str == null || str.isEmpty())
            return "";
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        StringBuilder buf = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            pq.offer(entry);
        }
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.peek();
            if (buf.length() > 0 && buf.charAt(buf.length() - 1) == entry.getKey()) {
                Map.Entry<Character, Integer> tmp1 = pq.poll();
                if (pq.isEmpty())
                    return "";
                Map.Entry<Character, Integer> tmp2 = pq.poll();
                buf.append(tmp2.getKey());
                tmp2.setValue(tmp2.getValue() - 1);
                pq.offer(tmp1);
                if (tmp2.getValue() > 0)
                    pq.offer(tmp2);
            } else {
                Map.Entry<Character, Integer> tmp1 = pq.poll();
                buf.append(tmp1.getKey());
                tmp1.setValue(tmp1.getValue() - 1);
                if (tmp1.getValue() > 0)
                    pq.offer(tmp1);
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }

}
