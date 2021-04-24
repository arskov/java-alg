package com.github.akovalchuk;

/**
 * Educative.io. Search Bitonic Array (medium)
 */
public class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        if (arr == null || arr.length == 0)
            return -1;
        int lo = 0;
        int hi = arr.length - 1;
        int peak = -1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] > arr[mi + 1]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        peak = lo;
        if (key == arr[peak]) {
            return peak;
        }
        if (key >= arr[0] && key < arr[peak]) {
            int found = bs(arr, 0, peak, key, false);
            if (found != -1)
                return found;
        }
        if (key >= arr[arr.length - 1] && key < arr[peak]) {
            int found = bs(arr, peak, arr.length - 1, key, true);
            if (found != -1)
                return found;
        }
        return -1;
    }

    private static int bs(int[] arr, int lo, int hi, int key, boolean reverse) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] == key) {
                return mi;
            } else if (key < arr[mi]) {
                if (!reverse) {
                    hi = mi - 1;
                } else {
                    lo = mi + 1;
                }
            } else {
                if (!reverse) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }

}
