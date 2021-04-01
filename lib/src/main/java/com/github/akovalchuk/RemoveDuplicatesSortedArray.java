package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Educative.io. Remove Duplicates (easy)
 */
public class RemoveDuplicatesSortedArray {

    public static int remove(int[] arr) {
        int l = 0;
        for (int r = 1; r < arr.length; r++) {
            if (arr[l] != arr[r]) {
                l++;
                int tmp = arr[r];
                arr[r] = arr[l];
                arr[l] = tmp;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] test = { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(Arrays.toString(Arrays.copyOf(test, remove(test))));
    }
}
