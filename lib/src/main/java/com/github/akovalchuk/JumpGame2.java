package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 45. Jump Game II
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len - 1; i++) {
            int last = Math.min(len - 1, i + nums[i]);
            for (int j = i; j <= last; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        var game = new JumpGame2();
        int[] test1 = {2,3,1,1,4};
        System.out.println(game.jump(test1));
        int[] test2 = {2,3,0,1,4};
        System.out.println(game.jump(test2));
    }

}
