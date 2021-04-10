package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 41. First Missing Positive
 * 
 * Educative.io. Find the Smallest Missing Positive Number (medium)
 */
public class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        if (nums == null)
            return 0;
        int i = 0;
        int k = nums.length - 1;
        while (i <= k) {
            int j = nums[i];
            if (j < 0) {
                swap(nums, i, k);
                k--;
            } else {
                if (j < nums[0]) {
                    swap(nums, 0, i);
                }
                i++;
            }
        }
        if (nums[0] > 1) {
            return 1;
        } else {
            int a = nums[0];
            i = 1;
            while (i <= k) {
                int j = nums[i] - a;
                if (j <= k && nums[i] != nums[j]) {
                    swap(nums, i, j);
                } else {
                    i++;
                }
            }
            System.out.println(Arrays.toString(nums));
            for (i = 1; i < nums.length; i++) {
                if (nums[i] != i + nums[0])
                    return i + nums[0];
            }
        }
        return -1;
    }

    public static int findNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }
        System.out.println(Arrays.toString(nums));
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(findNumber2(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(findNumber(new int[] { -3, 1, -5, 4, 2, 3, 7 }));
        System.out.println(findNumber2(new int[] { -3, 1, -5, 4, 2, 3, 7 }));
        System.out.println(findNumber(new int[] { -3, 1, -5, 4, 2, 3, 0, 7 }));
        System.out.println(findNumber2(new int[] { -3, 1, -5, 4, 2, 3, 0, 7 }));
        System.out.println(findNumber(new int[] { 2, 3, 4 }));
        System.out.println(findNumber2(new int[] { 2, 3, 4 }));
    }

}
