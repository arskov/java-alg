package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Educative.io Longest Substring with K Distinct Characters
 */
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || k == 0) return 0;
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        int j = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            LinkedList<Integer> list = map.getOrDefault(c, new LinkedList<>());
            list.add(i);
            map.put(c, list);
            while (check(map) > k) {
                char a = str.charAt(j);
                map.get(a).removeFirst();
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    private static int check(HashMap<Character, LinkedList<Integer>> map) {
        int count = 0;
        for (var e : map.entrySet()) {
            if (!e.getValue().isEmpty()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
    }
}
