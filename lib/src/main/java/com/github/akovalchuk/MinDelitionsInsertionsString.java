package com.github.akovalchuk;

/**
 * Educative.io. Minimum Deletions & Insertions to Transform a String into
 * another
 * 
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting and
 * inserting characters. Write a function to calculate the count of the minimum
 * number of deletion and insertion operations.
 */
public class MinDelitionsInsertionsString {

    public static void findMDI(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int lcs = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                lcs = Math.max(lcs, dp[i][j]);
            }
        }
        System.out.println("Minimum deletions needed: " + (s1.length() - lcs));
        System.out.println("Minimum insertions needed: " + (s2.length() - lcs));
    }

    public static void main(String[] args) {
        findMDI("abc", "fbc");
        findMDI("abdca", "cbda");
        findMDI("passport", "ppsspt");
    }

}
