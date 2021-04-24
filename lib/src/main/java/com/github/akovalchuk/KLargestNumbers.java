package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Educative.io. Top 'K' Numbers (easy)
 */
public class KLargestNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int kMin = nums.length - k;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int p = partition(nums, l, r);
            if (p == kMin) {
                break;
            } else if (p < kMin) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        for (int i = kMin; i < nums.length; i++)
            result.add(nums[i]);
        return result;
    }

    private static int partition(int[] nums, int l, int r) {
        int el = nums[r];
        int j = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] < el) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, r);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
