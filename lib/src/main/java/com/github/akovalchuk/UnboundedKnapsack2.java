package com.github.akovalchuk;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * Educative.io. Unbounded Knapsack
 * <p>
 * Given the weights and profits of ‘N’ items, we are asked to put these items
 * in a knapsack that has a capacity ‘C’. The goal is to get the maximum profit
 * from the items in the knapsack. The only difference between the 0/1 Knapsack
 * problem and this problem is that we are allowed to use an unlimited quantity
 * of an item.
 */
public class UnboundedKnapsack2 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null || profits.length == 0 || weights.length == 0
                || profits.length != weights.length)
            return 0;
        Integer[][] memo = new Integer[profits.length][capacity + 1];
        return solve(profits, weights, 0, capacity, memo);
    }

    private int solve(int[] profits, int[] weights, int i, int capacity, Integer[][] memo) {
        if (i >= profits.length) {
            return 0;
        }
        if (memo[i][capacity] != null) {
            return memo[i][capacity];
        }
        int l = 0;
        if (weights[i] <= capacity) {
            l = profits[i] + solve(profits, weights, i, capacity - weights[i], memo);
        }
        int r = solve(profits, weights, i + 1, capacity, memo);
        memo[i][capacity] = Math.max(l, r);
        return memo[i][capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack2 ks = new UnboundedKnapsack2();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
