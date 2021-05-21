package com.github.akovalchuk;

/**
 * Educative.io. Minimum Coin Change
 */
public class MinCoinChange {

    public int countChange(int[] denom, int total) {
        if (denom == null || denom.length == 0)
            return 0;
        Integer[][] memo = new Integer[denom.length][total + 1];
        int res = dfs(denom, 0, total, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] denom, int i, int total, Integer[][] memo) {
        if (total == 0) {
            return 0;
        }
        if (i == denom.length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][total] != null) {
            return memo[i][total];
        }
        int l = Integer.MAX_VALUE;
        if (denom[i] <= total) {
            int res = dfs(denom, i, total - denom[i], memo);
            if (res != Integer.MAX_VALUE) {
                l = 1 + res;
            }
        }
        int r = dfs(denom, i + 1, total, memo);
        memo[i][total] = Math.min(l, r);
        return memo[i][total];
    }

    public static void main(String[] args) {
        MinCoinChange cc = new MinCoinChange();
        int[] denominations = { 1, 2, 3 };
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[] { 3, 5 };
        System.out.println(cc.countChange(denominations, 7));
    }
}
