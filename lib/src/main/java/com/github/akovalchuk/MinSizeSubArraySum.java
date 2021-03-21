package com.github.akovalchuk;

/**
 * Educative.io. Smallest Subarray with a given sum
 */
public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int min = Integer.MAX_VALUE;
        int j = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            while (cur >= S && j <= i && j < arr.length) {
                min = Math.min(min, i - j + 1);
                cur -= arr[j];
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
