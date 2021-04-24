package com.github.akovalchuk;

/**
 * Educative.io. Number Range (medium)
 */
public class FindRange {
    
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        if (arr == null || arr.length == 0)
            return result;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (key == arr[mi]) {
                if (mi > 0 && arr[mi - 1] == arr[mi]) {
                    hi = mi - 1;
                } else {
                    result[0] = mi;
                    break;
                }
            } else if (key > arr[mi]) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        if (result[0] == -1)
            return result;
        lo = result[0];
        hi = arr.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (arr[mi] == key) {
                if (mi != arr.length - 1 && arr[mi] == arr[mi + 1]) {
                    lo = mi + 1;
                } else {
                    result[1] = mi;
                    break;
                }
            } else if (key < arr[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
