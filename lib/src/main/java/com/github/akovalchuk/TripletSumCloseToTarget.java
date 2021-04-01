package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. Triplet Sum Close to Target (medium)
 */
public class TripletSumCloseToTarget {
    
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3) return -1;
        Arrays.sort(arr);
        int closest = Integer.MAX_VALUE;
        outer:
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            int num = arr[i];
            while (l < r) {
                int sum = num + arr[l] + arr[r];
                if (Math.abs(targetSum - sum) < Math.abs(targetSum - closest)) {
                    closest = sum;
                }
                if (sum == targetSum) {
                    break outer;
                } else if (sum < targetSum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
