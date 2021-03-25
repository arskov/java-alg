package com.github.akovalchuk;

/**
 * Educative.io. Longest Subarray with Ones after Replacement (hard)
 */
public class ReplacingOnes {

    public static int findLength(int[] arr, int k) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                if (zeros == k) {
                    while (arr[left] != 0) {
                        left++;
                    }
                    left++;
                    zeros--;
                }
                zeros++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2) == 6); 
        System.out.println(findLength(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3) == 9); 
    }
}
