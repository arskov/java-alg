package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode. 15. 3Sum
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return Collections.emptyList();
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            var pairs = twoSum(nums, i, -nums[i]);
            for (var pair : pairs) {
                result.add(List.of(nums[i], nums[pair.get(0)], nums[pair.get(1)]));
            }
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        var map = new HashMap<Integer, Integer>();
        var res = new ArrayList<List<Integer>>();
        for (int i = start + 1; i < nums.length; i++) {
            var comp = target - nums[i];
            if (map.containsKey(comp)) {
                res.add(List.of(map.get(comp), i));
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(threeSum(new int[] { 0, 0, 0 }));
    }
}
