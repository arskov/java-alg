package com.github.akovalchuk;

/**
 * Leetcode. 152. Maximum Product Subarray
 */
public class MaxProductSubArray {
    
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int a = max * nums[i];
            int b = min * nums[i];
            max = Math.max(nums[i], Math.max(a, b));
            min = Math.min(nums[i], Math.min(a, b));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new MaxProductSubArray();
        int[] test1 = {-2,3,-4};
        int[] test2 = {1,2,-4,6};
        System.out.println(s.maxProduct(test1));
        System.out.println(s.maxProduct(test2));
    }
}
