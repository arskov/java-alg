package com.github.akovalchuk;

public class LongestPalindromicSubsting {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int len = s.length();
        int maxLen = 0;
        int st = 0, en = 0;
        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                st = i;
                en = i + 1;
            }
        }
        for (int j = 3; j <= len; j++) {
            for (int i = 0; i <= len - j; i++) {
                if (dp[i + 1][i + j - 1 - 1] && s.charAt(i) == s.charAt(i + j - 1)) {
                    dp[i][i + j - 1] = true;
                    if (j > maxLen) {
                        st = i;
                        en = i + j - 1;
                    }
                }
            }
        }
        return s.substring(st, en + 1);
    }

    public static void main(String[] args) {
        var sol = new LongestPalindromicSubsting();
        System.out.println(sol.longestPalindrome("bbbab"));
        System.out.println(sol.longestPalindrome("abbab"));
        System.out.println(sol.longestPalindrome("cbbcbaba"));
    }
}
