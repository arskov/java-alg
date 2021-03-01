package com.github.akovalchuk;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionInASortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int s = -1;
        int e = -1;
        if (nums[m] == target) {
            s = m;
            while (s > 0 && nums[s] == target) s--;
            e = m;
            while (e < nums.length && nums[e] == target) e++;
            s++;
            e--;
        }
        return new int[] {s, e};
    }

    public static void main(String[] args) {
        var sol = new FindFirstAndLastPositionInASortedArray();
        int[] test1 = {1,4};
        int[] test2 = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(sol.searchRange(test1, 4)));
        System.out.println(Arrays.toString(sol.searchRange(test2, 8)));
    }
}
