package com.github.akovalchuk;

/**
 * Educative.io. Ceiling of a Number (medium)
 */
public class CeilingOfNumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr == null || arr.length == 0)
            return -1;
        int lo = 0;
        int hi = arr.length - 1;
        int mi = 0;
        while (lo < hi) {
            mi = lo + (hi - lo) / 2;
            if (arr[mi] == key) {
                return mi;
            } else if (key < arr[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return key > arr[hi] ? -1 : hi;
    }

    public static void main(String[] args) {
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6) == 1);
        System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12) == 4);
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17) == -1);
        System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1) == 0);
    }
    
}
