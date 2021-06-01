package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Leetcode. 438. Find All Anagrams in a String
 */
public class FindAnagrams1 {

    private static final BiFunction<Character, Integer, Integer> inc = (k, v) -> v == null || v == 0 ? 1 : v + 1;
    private static final BiFunction<Character, Integer, Integer> dec = (k, v) -> v - 1;

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || (s.length() < p.length())) return List.of();
        var result = new ArrayList<Integer>();
        var dic = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            dic.compute(p.charAt(i), inc);
        }
        int l = 0;
        int matched = 0;
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (dic.containsKey(rc)) {
                dic.compute(rc, dec);
                if (dic.get(rc) == 0) matched++;
            }
            if (matched == dic.size()) {
                result.add(l);
            }
            if (r >= p.length() - 1) {
                char lc = s.charAt(l);
                if (dic.containsKey(lc)) {
                    if (dic.get(lc) == 0) matched--;
                    dic.compute(lc, inc);
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
