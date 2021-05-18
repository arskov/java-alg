package com.github.akovalchuk;

/**
 * Leetcode. 647. Palindromic Substrings
 */
public class CountPalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            ans++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                dp[i][i + l - 1] = dp[i + 1][i + l - 2] && s.charAt(i) == s.charAt(i + l - 1);
                if (dp[i][i + l - 1] == true) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
