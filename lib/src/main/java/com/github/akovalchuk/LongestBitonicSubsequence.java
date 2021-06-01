package com.github.akovalchuk;

/**
 * Educative.io. Longest Bitonic Subsequence
 * 
 * Given a number sequence, find the length of its Longest Bitonic Subsequence
 * (LBS). A subsequence is considered bitonic if it is monotonically increasing
 * and then monotonically decreasing.
 */
public class LongestBitonicSubsequence {

    public static int findLBSLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = 0;
        Integer[][] lcs1 = new Integer[nums.length][nums.length];
        Integer[][] lcs2 = new Integer[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int a = findDescFroward(nums, -1, i, lcs1);
            int b = findDescReverse(nums, -1, i, lcs2);
            max = Math.max(max, a + b - 1);
        }
        return max;
    }

    private static int findDescFroward(int[] nums, int prev, int next, Integer[][] memo) {
        if (next == nums.length) {
            return 0;
        }
        if (prev != -1 && memo[prev][next] != null) {
            return memo[prev][next];
        }
        int a = 0;
        if (prev == -1 || nums[prev] > nums[next]) {
            a = 1 + findDescFroward(nums, next, next + 1, memo);
        }
        int b = findDescFroward(nums, prev, next + 1, memo);
        int res = Math.max(a, b);
        if (prev != -1) {
            memo[prev][next] = res;
        }
        return res;
    }

    private static int findDescReverse(int[] nums, int prev, int next, Integer[][] memo) {
        if (next == -1) {
            return 0;
        }
        if (next != -1 && prev != -1 && memo[prev][next] != null) {
            return memo[prev][next];
        }
        int a = 0;
        if (prev == -1 || nums[prev] > nums[next]) {
            a = 1 + findDescReverse(nums, next, next - 1, memo);
        }
        int b = findDescReverse(nums, prev, next - 1, memo);
        int res = Math.max(a, b);
        if (prev != -1 && next != -1) {
            memo[prev][next] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
        System.out.println(findLBSLength(nums));
        nums = new int[] { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        System.out.println(findLBSLength(nums));
    }

}
