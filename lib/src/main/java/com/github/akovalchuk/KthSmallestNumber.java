package com.github.akovalchuk;

/**
 * Educative.io. Kth Smallest Number (easy)
 */
public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int p = partition(nums, l, r);
            if (p == k - 1) {
                return nums[p];
            } else if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int j = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, r);
        return j;
    }

    private static void swap(int[] nums, int l, int r) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers
        // should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
