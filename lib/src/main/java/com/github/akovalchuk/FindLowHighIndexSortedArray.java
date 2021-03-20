package com.github.akovalchuk;

import java.util.Arrays;
import java.util.List;

/**
 * Educative.io: Find Low/High Index of a Key in a Sorted Array
 */
public class FindLowHighIndexSortedArray {

    static int findLowIndex(List<Integer> arr, int key) {
        if (arr == null || arr.isEmpty())
            return -1;
        int lo = 0;
        int hi = arr.size() - 1;
        int mi = 0;
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            if (arr.get(mi) == key) {
                if (mi == 0 || mi > 0 && arr.get(mi - 1) < key)
                    return mi;
                else if (mi > 0 && arr.get(mi - 1) == key)
                    hi = mi - 1;
            } else if (key < arr.get(mi)) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return -1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        if (arr == null || arr.isEmpty())
            return -1;
        int last = arr.size() - 1;
        int lo = 0;
        int hi = last;
        int mi = 0;
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            if (arr.get(mi) == key) {
                if (mi == arr.size() - 1 || mi < arr.size() - 1 && arr.get(mi + 1) > key)
                    return mi;
                else if (mi == last || mi < last && arr.get(mi - 1) == key)
                    lo = mi + 1;
            } else if (key < arr.get(mi)) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        int key = 5;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }
}
