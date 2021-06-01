package com.github.akovalchuk;

/**
 * Educative.io. Subsequence Pattern Matching
 * 
 * Given a string and a pattern, write a method to count the number of times the
 * pattern appears in the string as a subsequence.
 * 
 * Example 1: Input: string: “baxmx”, pattern: “ax” Output: 2 Explanation:
 * {baxmx, baxmx}.
 * 
 * Example 2:
 * 
 * Input: string: “tomorrow”, pattern: “tor” Output: 4 Explanation: Following
 * are the four occurences: {tomorrow, tomorrow, tomorrow, tomorrow}.
 */
public class SubsequencePatternMatching {

    public static int findSPMCountTopDown(String str, String pat) {
        if (str == null || str.isEmpty())
            return 0;
        Integer[][] memo = new Integer[str.length()][pat.length()];
        return find(str, pat, 0, 0, memo);
    }

    private static int find(String str, String pat, int i, int j, Integer[][] memo) {
        if (j == pat.length())
            return 1;
        if (i == str.length())
            return 0;
        if (memo[i][j] == null) {
            int a = 0;
            if (str.charAt(i) == pat.charAt(j)) {
                a = find(str, pat, i + 1, j + 1, memo);
            }
            int b = find(str, pat, i + 1, j, memo);
            memo[i][j] = a + b;
        }
        return memo[i][j];
    }

    public static int findSPMCountBottomUp(String str, String pat) {
        if (str == null || str.isEmpty())
            return 0;
        int[][] dp = new int[str.length() + 1][pat.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[str.length()][pat.length()];
    }

    public static void main(String[] args) {
        System.out.println(findSPMCountTopDown("baxmx", "ax"));
        System.out.println(findSPMCountTopDown("tomorrow", "tor"));
        System.out.println();
        System.out.println(findSPMCountBottomUp("baxmx", "ax"));
        System.out.println(findSPMCountBottomUp("tomorrow", "tor"));
    }
}
