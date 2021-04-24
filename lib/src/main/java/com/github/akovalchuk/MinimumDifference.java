package com.github.akovalchuk;

/**
 * Educative.io. Minimum Difference Element (medium)
 */
public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        if (arr == null || arr.length == 0)
            return -1;
        int lo = 0;
        int hi = arr.length - 1;
        int minIdx = hi - lo / 2;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (key == arr[mi]) {
                return key;
            } else if (key < arr[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
            if (Math.abs(key - arr[mi]) <= Math.abs(key - arr[minIdx])) {
                minIdx = mi;
            }
        }
        return arr[minIdx];
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
