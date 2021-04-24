package com.github.akovalchuk;

/**
 * Leetcode. 832. Flipping an Image
 */
public class FlippingTheImage {
    public static int[][] flipAndInvertImage(int[][] arr) {
        if (arr == null || arr.length == 0)
            return arr;
        int rowLen = arr[0].length;
        for (int[] row : arr) {
            int l = 0;
            int r = rowLen - 1;
            while (l <= r) {
                int tmp = row[l];
                row[l] = row[r] ^ 1;
                row[r] = tmp ^ 1;
                l++;
                r--;
            }
        }
        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
        print(flipAndInvertImage(arr));

        int[][] arr2 = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        print(flipAndInvertImage(arr2));
    }
}
