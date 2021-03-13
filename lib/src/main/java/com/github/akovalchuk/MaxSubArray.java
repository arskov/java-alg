package com.github.akovalchuk;

/**
 * 53. Maximum Subarray
 */
public class MaxSubArray {
    
    public static int maxSubArrayKadanes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = prev + nums[i];
            prev = (tmp > nums[i]) ? tmp : nums[i];
            max = Math.max(max, prev);
        }
        return max;
    }

    public static int maxSubArraySplit(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return devide(nums, 0, nums.length);
    }

    private static int devide(int[] nums, int s, int e) {
        if (s >= e) return nums[e];
        int m = s + (e - s) / 2;
        int l = devide(nums, s, m);
        int r = devide(nums, m + 1, e);
        int c = cross(nums, s, e, m);
        return Math.max(c, Math.max(l, r));
    }
    
    private static int cross(int[] nums, int s, int e, int m) {
        if (s == e) return nums[s];
        int leftSubsum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = m; i >= s; i--) {
            curSum += nums[i];
            leftSubsum = Math.max(leftSubsum, curSum);
        }
        int rightSubsum = Integer.MIN_VALUE;
        curSum = 0;
        for (int i = m + 1; i <= e; i++) {
            curSum += nums[i];
            rightSubsum = Math.max(rightSubsum, curSum);
        }
        return leftSubsum + rightSubsum;
    }

    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayKadanes(test1) == 6);
        System.out.println(maxSubArraySplit(test1) == 6);
    }

}
