package com.github.akovalchuk;

public class SearchRotatedArray {

    static int binarySearchRotated(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        int mi = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (arr[mi] > arr[hi]) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        int startIdx = hi + 1;
        if (key == arr[startIdx])
            return startIdx;
        if (key > arr[startIdx] && key <= arr[arr.length - 1]) {
            lo = startIdx + 1;
            hi = arr.length - 1;
        } else {
            lo = 0;
            hi = startIdx - 1;
        }
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            if (key == arr[mi]) {
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
