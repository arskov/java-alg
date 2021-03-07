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
            key = (k == 0 ? sum : sum % k);
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
        int[] test1 = {23,2,6,2,5}; int k1 = 6;
        System.out.println(s.checkSubarraySum(test1, k1));
        int[] test2 = {0,1,0}; int k2 = 0;
        System.out.println(s.checkSubarraySum(test2, k2));
        int[] test3 = {0,1,2}; int k3 = 3;
        System.out.println(s.checkSubarraySum(test3, k3));
    }

}
