package com.github.akovalchuk;

/**
 * Leetcode. 486. Predict the Winner
 */
public class PredictWinner {

    public boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    
    private int helper(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        int a = nums[s] - helper(nums, s + 1, e);
        int b = nums[e] - helper(nums, s, e - 1);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        var sol = new PredictWinner();
        System.out.println(sol.predictTheWinner(new int[] {1, 5, 233, 7}));
        System.out.println(sol.predictTheWinner(new int[] {1, 5, 2}));
    }
}
