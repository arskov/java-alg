package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 358. Rearrange String k Distance Apart
 */
public class RearrangeStringKDist {

    public String rearrangeString(String s, int n) {
        if (s == null || s.length() == 0) return "";
        if (n == 0) return s;
        var dic = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dic.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return Character.compare(a.getKey(), b.getKey());
            } else {
                return Integer.compare(b.getValue(), a.getValue());
            }
        });
        pq.addAll(dic.entrySet());
        var result = new StringBuilder();
        var tmp = new LinkedList<Map.Entry<Character, Integer>>();
        while (!pq.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (!pq.isEmpty()) {
                    tmp.addLast(pq.poll());
                    result.append(tmp.peekLast().getKey());
                } else {
                    result.append('-');
                }
            }
            while (!tmp.isEmpty()) {
                var elem = tmp.pollFirst();
                if (elem.getValue() > 1) {
                    elem.setValue(elem.getValue() - 1);
                    pq.offer(elem);
                }
            }
        }
        //System.out.println(result);
        while (result.charAt(result.length() - 1) == '-') result.deleteCharAt(result.length() - 1);
        //System.out.println(result);
        if (result.indexOf("-") >= 0) 
            return "";
        else
            return result.toString();
    }

    public static void main(String[] args) {
        var sol = new RearrangeStringKDist();
        System.out.println(sol.rearrangeString("aabbcc", 3)); // "abcabc" 
        System.out.println(sol.rearrangeString("aaabc", 3)); // ""
        System.out.println(sol.rearrangeString("aaadbbcc", 2)); // "abacabcd"
        System.out.println(sol.rearrangeString("aaaaaadbbcc", 2)); // "abacabacada"
        System.out.println(sol.rearrangeString("a", 0));
    }
}
