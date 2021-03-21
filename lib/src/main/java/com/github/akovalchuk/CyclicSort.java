package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. Cyclic Sort
 */
public class CyclicSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = {3, 1, 5, 4, 2};
        sort(test1);
        System.out.println(Arrays.toString(test1));
        int[] test2 = {2, 6, 4, 3, 1, 5};
        sort(test2);
        System.out.println(Arrays.toString(test2));
    }
}
