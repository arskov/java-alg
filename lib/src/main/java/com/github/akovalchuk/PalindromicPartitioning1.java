package com.github.akovalchuk;

/**
 * Educative.io. Palindromic Partitioning
 * Leetcode. 132. Palindrome Partitioning II (Time Limit Exceeded)
 * <p>
 * Given a string, we want to cut it into pieces such that each piece is a
 * palindrome. Write a function to return the minimum number of cuts needed.
 */
public class PalindromicPartitioning1 {

    public static int partition(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int n = str.length();
        Integer[][] memo = new Integer[n][n];
        return dfs(str, 0, n - 1, memo);
    }

    private static int dfs(String str, int s, int e, Integer[][] memo) {
        if (s >= e) {
            return 0;
        }
        if (memo[s][e] != null) {
            return memo[s][e];
        }
        if (isPalindrome(str, s, e)) {
            memo[s][e] = 0;
            return memo[s][e];
        }
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for (int k = s; k < e; k++) {
            count = dfs(str, s, k, memo) + 1 + dfs(str, k + 1, e, memo);
            ans = Math.min(ans, count);
        }
        memo[s][e] = ans;
        return memo[s][e];
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("abc"));
        System.out.println(partition("aab"));
        System.out.println(partition("aaa"));
        System.out.println(partition("abdbca"));
        System.out.println(partition("cddpd"));
    }
}
