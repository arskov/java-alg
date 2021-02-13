package com.github.akovalchuk;

/*
* 395. Longest Substring with At Least K Repeating Characters
*/
public class LongestSubstringAtLeastKRepeating {

    public int longestSubstring(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) return 0;
        return longest(s, 0, s.length() - 1, k);
    }
    
    private int longest(String s, int start, int end, int k) {
        if (start > end) return 0;
        int[] dict = new int[26];
        for (int i = start; i <= end; i++) {
            dict[s.charAt(i) - 'a']++;
        }
        int mid = -1;
        for (int i = start; i <= end; i++) {
            int count = dict[s.charAt(i) - 'a'];
            if (count > 0 && count < k) {
                mid = i;
                break;
            }
        }
        if (mid == -1) return end - start + 1;
        return Math.max(longest(s, start, mid - 1, k), longest(s, mid + 1, end, k));
    }
    
    private boolean check(int[] dict, int k) {
        for (int v : dict) {
            if (v > 0 && v < k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new LongestSubstringAtLeastKRepeating();
        System.out.println(sol.longestSubstring("aaabb", 3));
        System.out.println(sol.longestSubstring("ababbc", 2));
    }
}
