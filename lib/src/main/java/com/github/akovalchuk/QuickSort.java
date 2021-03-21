package com.github.akovalchuk;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        helper(arr, 0, arr.length - 1);
    }

    private static void helper(int[] arr, int s, int e) {
        if (s >= e)
            return;
        int m = partition(arr, s, e);
        helper(arr, s, m - 1);
        helper(arr, m + 1, e);
    }

    private static int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int j = s;
        for (int i = s; i <= e; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }
        int tmp = arr[j];
        arr[j] = pivot;
        arr[e] = tmp;
        return j;
    }

    public static void main(String[] args) {
        int[] test1 = {33, 6, 21, 12, 19, 29, 38, 22, 14, 40};
        quickSort(test1);
        System.out.println(Arrays.toString(test1));
    }
}
