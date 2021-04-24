package com.github.akovalchuk;

/**
 * Educative.io. Bitonic Array Maximum (easy)
 */
public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] > arr[mi + 1]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 2, 3, 4, 5, 6, 7, 10, 9, 8, 7, 6, 5, 4 }));
    }
    
}
