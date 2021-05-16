package com.github.akovalchuk;

/**
 * Educative.io. Minimum jumps with fee
 * <p>
 * Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the
 * fee that you have to pay if you take the step. Implement a method to
 * calculate the minimum fee required to reach the top of the staircase (beyond
 * the top-most step). At every step, you have an option to take either 1 step,
 * 2 steps, or 3 steps. You should assume that you are standing at the first
 * step.
 */
public class MinimumJumpsWithFee {
    public static int findMinFee(int[] fee) {
        if (fee == null || fee.length == 0)
            return 0;
        Integer[] memo = new Integer[fee.length];
        return dfs(fee, 0, memo);
    }

    private static int dfs(int[] fee, int i, Integer[] memo) {
        if (i >= fee.length)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int p1 = dfs(fee, i + 1, memo);
        int p2 = dfs(fee, i + 2, memo);
        int p3 = dfs(fee, i + 3, memo);
        int min = Math.min(p1, Math.min(p2, p3));
        memo[i] = min + fee[i];
        return memo[i];
    }

    public static void main(String[] args) {
        int[] fee = { 1, 2, 5, 2, 1, 2 };
        System.out.println(findMinFee(fee));
        fee = new int[] { 2, 3, 4, 5 };
        System.out.println(findMinFee(fee));
    }
}
