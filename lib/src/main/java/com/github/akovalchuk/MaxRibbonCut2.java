package com.github.akovalchuk;

/**
 * Educative.io. Maximum Ribbon Cut
 * 
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. We
 * need to cut the ribbon into the maximum number of pieces that comply with the
 * above-mentioned possible lengths. Write a method that will return the count
 * of pieces.
 */
public class MaxRibbonCut2 {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        if (ribbonLengths == null || ribbonLengths.length == 0)
            return 0;
        int len = ribbonLengths.length;
        int[][] dp = new int[len][total + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (j == 0) {
                    dp[i][j] = 0;
                }
                if (i == 0 && j > 0 && ribbonLengths[0] <= j && dp[i][j - ribbonLengths[0]] != Integer.MIN_VALUE) {
                    dp[i][j] = 1 + dp[i][j - ribbonLengths[0]];
                }
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= total; j++) {
                int inc = Integer.MIN_VALUE;
                if (ribbonLengths[i] <= j && dp[i][j - ribbonLengths[i]] != Integer.MIN_VALUE) {
                    inc = 1 + dp[i][j - ribbonLengths[i]];
                }
                dp[i][j] = Math.max(dp[i - 1][j], inc);
            }
        }
        return dp[len - 1][total] == Integer.MIN_VALUE ? -1 : dp[len - 1][total];
    }

    public static void main(String[] args) {
        MaxRibbonCut2 cr = new MaxRibbonCut2();
        int[] ribbonLengths = { 2, 3, 5 };
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[] { 2, 3 };
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[] { 3, 5, 7 };
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[] { 3, 5 };
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
