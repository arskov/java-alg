package com.github.akovalchuk;

/**
 * Educative.io. Longest Repeating Subsequence
 * 
 * Given a sequence, find the length of its longest repeating subsequence (LRS).
 * A repeating subsequence will be the one that appears at least twice in the
 * original sequence and is not overlapping (i.e. none of the corresponding
 * characters in the repeating subsequences have the same index).
 */
public class LongestRepeatingSubsequence {

    public static int findLRSLengthTopDown(String str) {
        if (str == null || str.isEmpty())
            return 0;
        Integer[][] memo = new Integer[str.length()][str.length()];
        return find(str, 0, 0, memo);
    }

    private static int find(String str, int i1, int i2, Integer[][] memo) {
        if (i1 == str.length() || i2 == str.length())
            return 0;
        if (memo[i1][i2] != null)
            return memo[i1][i2];
        int a = 0;
        int b = 0;
        int c = 0;
        if (i1 != i2 && str.charAt(i1) == str.charAt(i2)) {
            a = 1 + find(str, i1 + 1, i2 + 1, memo);
        } else {
            b = find(str, i1 + 1, i2, memo);
            c = find(str, i1, i2 + 1, memo);
        }
        memo[i1][i2] = Math.max(a, Math.max(b, c));
        return memo[i1][i2];
    }

    public static int findLRSLengthBottomUp(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int max = 0;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (i != j && str.charAt(i - 1) == str.charAt(j - 1)) {
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
        System.out.println(findLRSLengthTopDown("tomorrow"));
        System.out.println(findLRSLengthBottomUp("tomorrow"));
        System.out.println(findLRSLengthTopDown("aabdbcec"));
        System.out.println(findLRSLengthBottomUp("aabdbcec"));
        System.out.println(findLRSLengthTopDown("fmff"));
        System.out.println(findLRSLengthBottomUp("fmff"));
    }

}
