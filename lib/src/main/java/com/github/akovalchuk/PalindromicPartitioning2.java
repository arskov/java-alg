package com.github.akovalchuk;

/**
 * Educative.io. Palindromic Partitioning
 * 
 * Leetcode. 132. Palindrome Partitioning II
 * 
 * Given a string, we want to cut it into pieces such that each piece is a
 * palindrome. Write a function to return the minimum number of cuts needed.
 */
public class PalindromicPartitioning2 {

    public static int partition(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            isPalindrome[i - 1][i] = (str.charAt(i - 1) == str.charAt(i));
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= str.length() - l; i++) {
                isPalindrome[i][i + l - 1] = (isPalindrome[i + 1][i + l - 2] && str.charAt(i) == str.charAt(i + l - 1));
            }
        }
        int[] cuts = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int minCut = n;
            for (int j = n - 1; j >= i; j--) {
                if (isPalindrome[i][j]) {
                    minCut = (j == n - 1 ? 0 : Math.min(minCut, 1 + cuts[j + 1]));
                }
            }
            cuts[i] = minCut;
        }
        return cuts[0];
    }

    public static void main(String[] args) {
        System.out.println(partition("abc"));
        System.out.println(partition("aab"));
        System.out.println(partition("aaa"));
        System.out.println(partition("abdbca"));
        System.out.println(partition("cddpd"));
    }
}
