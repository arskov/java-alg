package com.github.akovalchuk;

/**
 * Educative.io: Find the Smallest Common Number
 */
public class SmallestCommonNumber {

    static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        if (arr1 == null || arr2 == null || arr3 == null)
            return -1;
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            if (a == b && b == c) {
                return a;
            } else if (a <= b && a <= c) {
                i++;
            } else if (b <= a && b <= c) {
                j++;
            } else if (c <= a && c <= b) {
                k++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{1, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};
        Integer result = findLeastCommonNumber(v1, v2, v3);
        System.out.println("Least Common Number: " + result);
    }
}
