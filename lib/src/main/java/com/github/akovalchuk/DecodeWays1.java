package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 91. Decode Ways
 */
public class DecodeWays1 {
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    
    private int helper(String s, int start, int[] dp) {
        if (start == s.length()) {
            return 1;
        }
        if (dp[start] != -1) return dp[start];
        if (s.charAt(start) == '0') {
            dp[start] = 0;
            return 0;
        }
        int count = helper(s, start + 1, dp);
        if (start <= s.length() - 2) {
            int val = (s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0');
            if (val <= 26) {
                count += helper(s, start + 2, dp);
            }
        }
        dp[start] = count;
        return count;
    }

    public static void main(String[] args) {
        var sol = new DecodeWays1();
        System.out.println(sol.numDecodings("123"));
        System.out.println(sol.numDecodings("123451234512345"));
        System.out.println(sol.numDecodings("11062"));
        System.out.println(sol.numDecodings("0123"));
    }
}
