package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. 0/1 Knapsack (medium)
 */
public class KnapsackZeroOne1 {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null || profits.length != weights.length) 
            return 0;
        int[][] memo = new int[profits.length][capacity + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, capacity, profits, weights, memo);
    }

    private static int dfs(int i, int cap, int[] p, int[] w, int[][] memo) {
        if (i >= p.length || cap <= 0) return 0;
        if (memo[i][cap] != -1) return memo[i][cap];
        int l = 0;
        if (w[i] <= cap)
            l = dfs(i + 1, cap - w[i], p, w, memo) + p[i];
        int r = dfs(i + 1, cap, p, w, memo);
        int result = Math.max(l, r);
        memo[i][cap] = result;
        return result;
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
