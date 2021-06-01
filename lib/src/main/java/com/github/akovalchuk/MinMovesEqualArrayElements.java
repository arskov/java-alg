package com.github.akovalchuk;

import java.util.Random;

/**
 * Leetcode. 462. Minimum Moves to Equal Array Elements II
 */
public class MinMovesEqualArrayElements {
    
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int sum = 0;
        int medIdx = len / 2;
        var rnd = new Random();
        for (int i = 0; i < len; i++) {
            swap(nums, i, rnd.nextInt(len));
        }
        int med = quickselect(nums, 0, len - 1, medIdx);
        for (int i = 0; i < len; i++) {
            sum += Math.abs(med - nums[i]);
        }
        return sum;
    }
    
    private int quickselect(int[] nums, int s, int e, int target) {
        while (s < e) {
            int i = partition(nums, s, e);
            if (i == target) {
                return nums[i];
            } else if (i < target) {
                s = i + 1;
            } else {
                e = i - 1;
            }
        }
        return nums[s];
    }
    
    private int partition(int[] nums, int s, int e) {
        int pivot = nums[e];
        int j = s;
        for (int i = s; i <= e; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, e);
        return j;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        var sol = new MinMovesEqualArrayElements();
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(sol.minMoves2(nums));
    }
}
