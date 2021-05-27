package com.github.akovalchuk;

import java.util.HashMap;

/**
 * Leetcode. 76. Minimum Window Substring
 */
public class MinWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";
        var mapT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        var mapS = new HashMap<Character, Integer>();
        int min = Integer.MAX_VALUE;
        var minString = "";
        int l = 0;
        int r = 0;
        int matched = 0;
        while (l < s.length() && r < s.length()) {
            char c = s.charAt(r);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            if (mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue()) {
                matched++;
            }
            while (l <= r && matched == mapT.size()) {
                c = s.charAt(l);
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    minString = s.substring(l, r + 1);
                }
                mapS.put(c, mapS.get(c) - 1);
                if (mapT.containsKey(c) && mapS.get(c).intValue() < mapT.get(c).intValue()) {
                    matched--;
                }
                l++;
            }
            r++;
        }
        return minString;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
