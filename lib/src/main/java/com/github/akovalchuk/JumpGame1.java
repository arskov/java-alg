package com.github.akovalchuk;

/**
 * Leetcode. 55. Jump Game
 */
public class JumpGame1 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Boolean[] memo = new Boolean[nums.length];
        return dfs(nums, 0, memo);
    }

    private boolean dfs(int[] nums, int start, Boolean[] memo) {
        if (start >= nums.length - 1) {
            memo[nums.length - 1] = true;
            return true;
        }
        if (memo[start] != null) return memo[start];
        int n = nums[start];
        for (int i = start + 1; i <= start + n; i++) {
            boolean res = dfs(nums, i, memo);
            if (res) {
                memo[i] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    public boolean canJumpGreedy(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int r = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= r) r = i;
        }
        return r == 0;
    }

    public static void main(String[] args) {
        var game = new JumpGame1();
        int[] test1 = {2,3,1,1,4};
        System.out.println(game.canJump(test1));
        System.out.println(game.canJumpGreedy(test1));
        int[] test2 = {3,2,1,0,4};
        System.out.println(game.canJump(test2));
        System.out.println(game.canJumpGreedy(test2));
    }

}
