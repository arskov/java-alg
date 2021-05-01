package com.github.akovalchuk;

/**
 * Educative.io. 0/1 Knapsack (medium)
 */
public class KnapsackZeroOne2 {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null || profits.length != weights.length) 
            return 0;
        int[][] dp = new int[profits.length][capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            if (weights[0] <= j)
                dp[0][j] = profits[0];
        }
        for (int i = 1; i < profits.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int p1 = dp[i - 1][j];
                int p2 = (weights[i] <= j ? dp[i - 1][j - weights[i]] + profits[i] : 0);
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[profits.length - 1][capacity];
    }

    public static void main(String[] args) {
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
