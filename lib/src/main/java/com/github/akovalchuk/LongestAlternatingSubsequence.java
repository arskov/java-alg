package com.github.akovalchuk;

/**
 * Educative.io. Longest Alternating Subsequence
 * 
 * Given a number sequence, find the length of its Longest Alternating
 * Subsequence (LAS). A subsequence is considered alternating if its elements
 * are in alternating order.
 * 
 * A three element sequence (a1, a2, a3) will be an alternating sequence if its
 * elements hold one of the following conditions:
 * 
 * {a1 > a2 < a3 } or { a1 < a2 > a3}.
 */
public class LongestAlternatingSubsequence {
    
    public static int findLASLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Integer[][][] memo = new Integer[nums.length][nums.length][2];
        int a = find(nums, 0, 1, 1, memo);
        int b = find(nums, 0, 1, 0, memo);
        return Math.max(a, b) + 1;
    }

    private static int find(int[] nums, int prev, int next, int isDesc, Integer[][][] memo) {
        if (next == nums.length) {
            return 0;
        }
        if (memo[prev][next][isDesc] != null) {
            return memo[prev][next][isDesc];
        }
        int a = 0;
        if ((isDesc == 1 && nums[prev] > nums[next]) || (isDesc == 0 && nums[prev] < nums[next])) {
            a = 1 + find(nums, next, next + 1, isDesc ^ 1, memo);
        }
        int b = find(nums, prev, next + 1, isDesc, memo);
        int res = Math.max(a, b);
        memo[prev][next][isDesc] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(findLASLength(nums));
        nums = new int[] { 3, 2, 1, 4 };
        System.out.println(findLASLength(nums));
        nums = new int[] { 1, 3, 2, 4 };
        System.out.println(findLASLength(nums));
        nums = new int[] { 7, 5, 3, 8, 4, 1, 3, 4, 5, 2, 1 };
        System.out.println(findLASLength(nums));
    }
}
