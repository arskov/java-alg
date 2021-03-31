package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;

/**
 * Educative.io. Smallest Window containing Substring (hard)
 */
public class SmallestSubstringContainingCharacters {

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int minLen = str.length();
        String minStr = "";
        int l = 0;
        int matched = 0;
        for (int r = 0; r < str.length(); r++) {
            char rc = str.charAt(r);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) == 0)
                    matched++;
            }
            while (matched == map.size()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStr = str.substring(l, r + 1);
                }
                char lc = str.charAt(l);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0)
                        matched--;
                    map.put(lc, map.get(lc) + 1);
                }
                l++;
            }
        }
        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
