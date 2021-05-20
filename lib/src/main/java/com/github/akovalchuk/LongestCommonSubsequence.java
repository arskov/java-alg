package com.github.akovalchuk;

/**
 * Educative.io. Longest Common Subsequence
 * <p>
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence
 * which is common in both the strings.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 */
public class LongestCommonSubsequence {

    public static int findLCSLengthRecursive(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return 0;
        return find(s1, s2, 0, 0);
    }

    private static int find(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length())
            return 0;
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            a = 1 + find(s1, s2, i1 + 1, i2 + 1);
        } else {
            b = find(s1, s2, i1 + 1, i2);
            c = find(s1, s2, i1, i2 + 1);
        }
        return Math.max(a, Math.max(b, c));
    }

    public static int findLCSLengthBottomUp(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLCSLengthRecursive("abdca", "cbda"));
        System.out.println(findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(findLCSLengthRecursive("passport", "ppsspt"));
        System.out.println(findLCSLengthBottomUp("passport", "ppsspt"));
    }
}
