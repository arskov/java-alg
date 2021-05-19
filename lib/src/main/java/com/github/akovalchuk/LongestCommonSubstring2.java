package com.github.akovalchuk;

/**
 * Educative.io. Longest Common Substring
 * <p>
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring
 * which is common in both the strings.
 */
public class LongestCommonSubstring2 {

    public static int findLCSLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return 0;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
