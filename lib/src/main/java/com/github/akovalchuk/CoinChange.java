package com.github.akovalchuk;

/**
 * Educative.io. Coin Change
 */
public class CoinChange {

    public int countChange(int[] denominations, int total) {
        if (denominations == null || denominations.length == 0)
            return 0;
        int len = denominations.length;
        int[][] dp = new int[len][total + 1];
        for (int i = 0; i < len; i++)
            dp[i][0] = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= total; j++) {
                if (i > 0)
                    dp[i][j] = dp[i - 1][j];
                if (denominations[i] <= j)
                    dp[i][j] = dp[i][j] + dp[i][j - denominations[i]];
            }
        }
        return dp[len - 1][total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = { 1, 2, 3 };
        System.out.println(cc.countChange(denominations, 5));
    }
}
