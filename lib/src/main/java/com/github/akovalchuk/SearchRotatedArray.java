package com.github.akovalchuk;

/**
 * Educative.io. Search in Rotated Array (medium)
 */
public class SearchRotatedArray {

    public static int binarySearchRotated(int[] arr, int key) {
        if (arr == null || arr.length == 0)
            return -1;
        int pivot = findPivot(arr);
        if (key >= arr[0]) {
            return binarySearch(arr, 0, pivot - 1, key);
        } else {
            return binarySearch(arr, pivot, arr.length - 1, key);
        }
    }

    private static int findPivot(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] > arr[hi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return hi;
    }

    private static int binarySearch(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] == key) {
                return mi;
            } else if (key < arr[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchRotated(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(binarySearchRotated(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
        System.out.println("--");
        int[] test = { 162, 176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155 };
        System.out.println(binarySearchRotated(test, 162));
        System.out.println(binarySearchRotated(test, 1));
        System.out.println(binarySearchRotated(test, 155));
        System.out.println(binarySearchRotated(test, 222));
        System.out.println(binarySearchRotated(test, 188));
        System.out.println(binarySearchRotated(test, 88));
        System.out.println(binarySearchRotated(test, 2));
        System.out.println(binarySearchRotated(test, 170));
    }
}
