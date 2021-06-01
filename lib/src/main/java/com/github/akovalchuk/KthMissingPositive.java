package com.github.akovalchuk;

/**
 * Leetcode. 1539. Kth Missing Positive Number
 */
public class KthMissingPositive {

    public static int findKthPositive1(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int i = 0;
        int num = 1;
        while (k > 0 && i < arr.length) {
            if (arr[i] == num) {
                i++;
            } else {
                k--;
            }
            num++;
        }
        return k == 0 ? num - 1 : num - 1 + k;
    }

    public static int findKthPositive2(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int max = arr[arr.length - 1];
        int num = 1, j = 0;
        for (int i = 1; i <= max && k > 0; i++) {
            if (arr[j] == i) {
                j++;
            } else {
                k--;
                num = i;
            }
        }
        return k == 0 ? num : max + k;
    }

    public static void main(String[] args) {
        int[] test1 = {2,3,4,7,11};
        System.out.println(findKthPositive1(test1, 5));
        System.out.println(findKthPositive2(test1, 5));
        int[] test2 = {1,2,3,4};
        System.out.println(findKthPositive1(test2, 2));
        System.out.println(findKthPositive2(test2, 2));
    }

}
