package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Educative.io. Find all Missing Numbers (easy)
 * 
 * 448. Find All Numbers Disappeared in an Array
 */
public class FindAllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) missingNumbers.add(i + 1);
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println(findNumbers(test1));
        int[] test2 = {2, 4, 1, 2};
        System.out.println(findNumbers(test2));
        int[] test3 = {2, 3, 2, 1};
        System.out.println(findNumbers(test3));
        int[] test4 = {1, 1};
        System.out.println(findNumbers(test4));
    }

}
