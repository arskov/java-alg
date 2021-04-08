package com.github.akovalchuk;

import java.util.TreeSet;

/**
 * Leetcode. 220. Contains Duplicate III
 */
public class FindNearestDuplicates {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j <= i + k && j < nums.length; j++) {
        //         if (Math.abs(nums[i] - nums[j]) <= t) return true;
        //     }
        // }
        // return false;
        var tree = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            var g = tree.ceiling(num);
            if (g != null && g - num <= t) return true;
            var l = tree.floor(num);
            if (l != null && num - l <= t) return true;
            tree.add(num);
            if (tree.size() > k) {
                tree.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[] {2147483646, 2147483647}, 3, 3)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9}, 2, 3)); // false
        System.out.println(containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3, 0)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[] {-2147483648, 2147483647}, 1, 1)); // false
    }
}
