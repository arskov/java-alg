package com.github.akovalchuk;

import java.util.HashMap;

/**
 * 523. Continuous Subarray Sum
 */
public class ContiguousSubarraySumModK {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0, key = 0;

        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            key = (k == 0 ? key : key % k);
            if (map.containsKey(key)) {
                if (i - map.get(key) > 1) return true;
            } else {
                map.put(key, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var s = new ContiguousSubarraySumModK();
        int[] test = {23,2,6,2,5}; int k = 6;
        System.out.println(s.checkSubarraySum(test, k));
    }

}
