package com.github.akovalchuk;

/**
 * Educative.io. House thief
 * <p>
 * There are n houses built in a line. A thief wants to steal the maximum
 * possible money from these houses. The only restriction the thief has is that
 * he can’t steal from two consecutive houses, as that would alert the security
 * system. How should the thief maximize his stealing?
 */
public class HouseThief {
    public static int findMaxSteal(int[] wealth) {
        if (wealth == null || wealth.length == 0)
            return 0;
        Integer[] memo = new Integer[wealth.length];
        return dfs(wealth, 0, memo);
    }

    private static int dfs(int[] wealth, int i, Integer[] memo) {
        if (i >= wealth.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int take = wealth[i] + dfs(wealth, i + 2, memo);
        int notTake = dfs(wealth, i + 1, memo);
        memo[i] = Math.max(take, notTake);
        return memo[i];
    }

    public static void main(String[] args) {
        int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
        System.out.println(findMaxSteal(wealth));
        wealth = new int[] { 2, 10, 14, 8, 1 };
        System.out.println(findMaxSteal(wealth));
    }
}
