package com.github.akovalchuk;

/**
 * Leetcode. 72. Edit Distance
 */
public class EditDistance1 {
    
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int val1 = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                int val2 = dp[i - 1][j] + 1;
                int val3 = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(val1, Math.min(val2, val3));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        var solution = new EditDistance1();
        System.out.println(solution.minDistance("hhoorrssee", "horse"));
    }

}
