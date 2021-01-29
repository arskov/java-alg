package com.github.akovalchuk;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        var dic = new HashSet<Character>();
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (dic.contains(c)) {
                while (dic.contains(c)) {
                    dic.remove(s.charAt(l++));
                }
            }
            dic.add(c);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var solution = new LongestSubstringWithoutRepeatingChars();
        System.out.println(solution.lengthOfLongestSubstring("abcdefg"));
        System.out.println(solution.lengthOfLongestSubstring("abcabc"));
        System.out.println(solution.lengthOfLongestSubstring("abaacdaaefaag"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
