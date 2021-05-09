package com.github.akovalchuk;

/**
 * Educative.io. Maximum Ribbon Cut
 * <p>
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. We
 * need to cut the ribbon into the maximum number of pieces that comply with the
 * above-mentioned possible lengths. Write a method that will return the count
 * of pieces.
 */
public class MaximumRibbonCut1 {

    public int countRibbonPieces(int[] ribbonLengths, int total) {
        if (ribbonLengths == null || ribbonLengths.length == 0)
            return 0;
        int len = ribbonLengths.length;
        Integer[][] memo = new Integer[len][total + 1];
        int res = dfs(ribbonLengths, 0, total, memo);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private int dfs(int[] ribbonLengths, int i, int total, Integer[][] memo) {
        if (total == 0) {
            return 0;
        }
        if (i == ribbonLengths.length) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][total] != null) {
            return memo[i][total];
        }
        int left = Integer.MIN_VALUE;
        if (ribbonLengths[i] <= total) {
            int res = dfs(ribbonLengths, i, total - ribbonLengths[i], memo);
            if (res != Integer.MIN_VALUE) {
                left = 1 + res;
            }
        }
        int right = dfs(ribbonLengths, i + 1, total, memo);
        memo[i][total] = Math.max(left, right);
        return memo[i][total];
    }

    public static void main(String[] args) {
        MaximumRibbonCut1 cr = new MaximumRibbonCut1();
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
