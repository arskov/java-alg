package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all Duplicate Numbers (easy)
 * 
 * Leetcode. 442. Find All Duplicates in an Array
 */
public class FindDuplicateNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }
        return duplicateNumbers;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] { 3, 4, 4, 5, 5 })); // [4, 5]
        System.out.println(findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 })); // [3, 5]
        System.out.println(findNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })); // [2, 3]
    }
}
