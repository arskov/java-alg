package com.github.akovalchuk;

/**
 * Educative.io. Minimum Window Sort (medium)
 * 
 * 581. Shortest Unsorted Continuous Subarray
 */
public class ShortestWindowSort {

    public static int sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxSoFar = 0;
        int winStart = -1;
        int winEnd = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[maxSoFar]) {
                maxSoFar = i;
            } else {
                winEnd = i;
                if (winStart == -1) winStart = i - 1;
                while (winStart > 0 && arr[winStart - 1] > arr[i]) winStart--;
            }
        }
        return (winEnd != -1) ? winEnd - winStart + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 3, 2, 0, -1, 7, 10}) == 5);
        System.out.println(sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}) == 5);
        System.out.println(sort(new int[]{1, 2, 3}) == 0);
        System.out.println(sort(new int[]{3, 2, 1}) == 3);
    }
}
