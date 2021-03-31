package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Educative.io. Find All Anagrams in a String
 */
public class FindAnagrams2 {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int matched = 0;
        for (int r = 0; r < str.length(); r++) {
            char rc = str.charAt(r);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) == 0)
                    matched++;
            }
            if (matched == map.size()) {
                resultIndices.add(l);
            }
            if (r >= pattern.length() - 1) {
                char lc = str.charAt(l);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) == 1)
                        matched--;
                }
                l++;
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }
}
