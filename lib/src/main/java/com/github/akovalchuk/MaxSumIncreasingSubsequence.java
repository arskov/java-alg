package com.github.akovalchuk;

/**
 * Educative.io. Maximum Sum Increasing Subsequence
 * <p>
 * Given a number sequence, find the increasing subsequence with the highest
 * sum. Write a method that returns the highest sum.
 */
public class MaxSumIncreasingSubsequence {

    public static int findMSIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Integer[][] memo = new Integer[nums.length][nums.length];
        return find(nums, -1, 0, memo);
    }

    private static int find(int[] nums, int prev, int next, Integer[][] memo) {
        if (next == nums.length)
            return 0;
        if (prev == -1 || memo[prev][next] == null) {
            return memo[prev][next];
        }
        int a = 0;
        if (prev == -1 || nums[prev] < nums[next]) {
            a = nums[next] + find(nums, next, next + 1, memo);
        }
        int b = find(nums, prev, next + 1, memo);
        int res = Math.max(a, b);
        if (prev != -1) {
            memo[prev][next] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 6, 10, 1, 12 };
        System.out.println(findMSIS(nums));
        nums = new int[] { -4, 10, 3, 7, 15 };
        System.out.println(findMSIS(nums));
    }
}
