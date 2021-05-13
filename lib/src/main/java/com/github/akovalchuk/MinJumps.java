package com.github.akovalchuk;

/**
 * Educative.io. Minimum jumps to reach the end
 * <p>
 * Given an array of positive numbers, where each element represents the max
 * number of jumps that can be made forward from that element, write a program
 * to find the minimum number of jumps needed to reach the end of the array
 * (starting from the first element). If an element is 0, then we cannot move
 * through that element.
 */
public class MinJumps {

    public static int countMinJumps(int[] jumps) {
        if (jumps == null || jumps.length == 0)
            return 0;
        Integer[] dp = new Integer[jumps.length];
        return dfs(jumps, 0, dp);
    }

    private static int dfs(int[] jumps, int i, Integer[] dp) {
        if (i >= jumps.length - 1)
            return 0;
        if (jumps[i] == 0)
            return Integer.MAX_VALUE;
        if (dp[i] != null)
            return dp[i];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= jumps[i]; j++) {
            int res = dfs(jumps, i + j, dp);
            if (res != Integer.MAX_VALUE && res + 1 < min) {
                min = res + 1;
            }
        }
        dp[i] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] jumps = { 2, 1, 1, 1, 4 };
        System.out.println(countMinJumps(jumps));
        jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
        System.out.println(countMinJumps(jumps));
    }
}
