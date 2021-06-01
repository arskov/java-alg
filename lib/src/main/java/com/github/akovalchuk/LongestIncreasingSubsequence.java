package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. Longest Increasing Subsequence
 * 
 * Given a number sequence, find the length of its Longest Increasing
 * Subsequence (LIS). In an increasing subsequence, all the elements are in
 * increasing order (from lowest to highest).
 */
public class LongestIncreasingSubsequence {

    public static int findLISLengthTopDown(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Integer[][] memo = new Integer[nums.length + 1][nums.length + 1];
        return find(nums, 0, 1, memo);
    }

    private static int find(int[] nums, int prev, int next, Integer[][] memo) {
        if (next == nums.length + 1)
            return 0;
        if (memo[prev][next] != null)
            return memo[prev][next];
        int a = 0;
        if (prev == 0 || nums[prev - 1] < nums[next - 1])
            a = 1 + find(nums, next, next + 1, memo);
        int b = find(nums, prev, next + 1, memo);
        memo[prev][next] = Math.max(a, b);
        return memo[prev][next];
    }

    public static int findLISLengthBottomUp(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[i], 1 + dp[i]);
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
        System.out.println(findLISLengthTopDown(nums));
        System.out.println(findLISLengthBottomUp(nums));
        nums = new int[] { -4, 10, 3, 7, 15 };
        System.out.println(findLISLengthTopDown(nums));
        System.out.println(findLISLengthBottomUp(nums));
    }
}
