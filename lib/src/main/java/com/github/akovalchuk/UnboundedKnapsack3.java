package com.github.akovalchuk;

/**
 * Educative.io. Unbounded Knapsack
 * 
 * Given the weights and profits of ‘N’ items, we are asked to put these items
 * in a knapsack that has a capacity ‘C’. The goal is to get the maximum profit
 * from the items in the knapsack. The only difference between the 0/1 Knapsack
 * problem and this problem is that we are allowed to use an unlimited quantity
 * of an item.
 */
public class UnboundedKnapsack3 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null || profits.length == 0 || weights.length == 0
                || profits.length != weights.length) {
            return 0;
        }
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int p1 = 0, p2 = 0;
                if (weights[i] <= c) {
                    p1 = profits[i] + dp[i][c - weights[i]];
                }
                if (i > 0) {
                    p2 = dp[i - 1][c];
                }
                dp[i][c] = Math.max(p1, p2);
            }
        }
        return dp[profits.length - 1][capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack2 ks = new UnboundedKnapsack2();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
