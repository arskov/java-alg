package com.github.akovalchuk;

import java.util.LinkedHashMap;

/**
 * Leetcode. 159. Longest Substring with At Most Two Distinct Characters
 */
public class LongestSubstringAtMost2Distinct {
    /**
    abaccc
    
        0  l=0
    b-1 1  l=0
    a-2 2  l=0
    c-3 3  
    
    */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() <= 2) return s.length();
        var dict = new LinkedHashMap<Character, Integer>();
        int max = 2;
        int r = 0;
        int l = 0;
        while (r < s.length()) {
            if (dict.containsKey(s.charAt(r))) dict.remove(s.charAt(r));
            dict.put(s.charAt(r), r++);
            if (dict.size() == 3) {
                var p = dict.entrySet().iterator().next();
                dict.remove(p.getKey());
                l = p.getValue() + 1;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new LongestSubstringAtMost2Distinct();
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("aa"));
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("a"));
    }
}
