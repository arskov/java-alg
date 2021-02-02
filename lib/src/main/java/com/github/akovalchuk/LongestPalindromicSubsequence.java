package com.github.akovalchuk;

public class LongestPalindromicSubsequence {
    
    public int longestPalindromeSubseqRecursive(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        char[] s1 = s.toCharArray();
        int len = s1.length;
        char[] s2 = new char[len];
        for (int i = 0; i < len; i++) {
            s2[i] = s1[len - 1 - i];
        }
        return lcsRecursive(s1, s2, len, len);
    }
    
    private int lcsRecursive(char[] a, char[] b, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (a[n - 1] == b[m - 1]) {
            return 1 + lcsRecursive(a, b, n - 1, m - 1);
        } else {
            return Math.max(lcsRecursive(a, b, n - 1, m), lcsRecursive(a, b, n, m - 1));
        }
    }

    public int longestPalindromeSubseqDP(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        char[] s1 = s.toCharArray();
        int len = s1.length;
        char[] s2 = new char[len];
        for (int i = 0; i < len; i++) {
            s2[i] = s1[len - 1 - i];
        }
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len][len];
    }

    public static void main(String[] args) {
        var sol = new LongestPalindromicSubsequence();
        System.out.println(sol.longestPalindromeSubseqRecursive("bbbab"));
        System.out.println(sol.longestPalindromeSubseqDP("bbbab"));
    }

}
