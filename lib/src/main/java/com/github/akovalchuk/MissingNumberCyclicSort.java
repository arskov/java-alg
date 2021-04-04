package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. Find the Missing Number (easy)
 */
public class MissingNumberCyclicSort {

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k) {
                return k;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = { 8, 3, 5, 2, 4, 6, 0, 1 };
        System.out.println(findMissingNumber(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = { 8, 3, 5, 2, 7, 6, 0, 1 };
        System.out.println(findMissingNumber(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}
