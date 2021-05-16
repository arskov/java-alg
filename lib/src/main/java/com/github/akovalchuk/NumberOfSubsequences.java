package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 1498. Number of Subsequences That Satisfy the Given Sum Condition
 */
public class NumberOfSubsequences {
    private static final int MOD = 1_000_000_000 + 7;

    public static int numSubseq(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                res = (res + pow[j - i]) % MOD;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3,5,6,7}, 9) == 4);
        System.out.println(numSubseq(new int[]{3,3,6,8}, 10) == 6);
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7}, 12) == 61);
        System.out.println(numSubseq(new int[]{5,2,4,1,7,6,8}, 16) == 127);
    }
}
