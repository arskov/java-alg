package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Educative.io. Find the First K Missing Positive Numbers
 */
public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        int i = 0;
        Set<Integer> memo = new HashSet<>();
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                if (nums[i] > 0) memo.add(nums[i]);
                i++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
                k--;
            }
        }
        int j = nums[nums.length - 1] + 1;
        while (k > 0) {
            if (!memo.contains(j)) {
                res.add(j);
                k--;
            }
            j++;
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3)); // [1, 2, 6]
        System.out.println(findNumbers(new int[] { 2, 3, 4 }, 3)); // [1, 5, 6]
    }
}
