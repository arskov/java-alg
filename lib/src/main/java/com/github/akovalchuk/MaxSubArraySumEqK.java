package com.github.akovalchuk;

import java.util.HashMap;

/**
 * Leetcode. 325. Maximum Size Subarray Sum Equals k
 */
public class MaxSubArraySumEqK {

    public int maxSubArrayLen_BF(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int prev = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            prev += nums[i];
            if (prev == k) {
                max = i + 1;
            }
            if (map.containsKey(prev - k)) {
                max = Math.max(max, map.get(prev - k));
            }
            map.putIfAbsent(prev, i);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new MaxSubArraySumEqK();
        int[] test1 = {1,2,3,4,5};
        System.out.println(s.maxSubArrayLen_BF(test1, 5));
        System.out.println(s.maxSubArrayLen_BF(test1, 5));
        int[] test2 = {1, -1, 5, -2, 3};
        System.out.println(s.maxSubArrayLen(test2, 3));
        System.out.println(s.maxSubArrayLen(test2, 3));
    }
    
}
