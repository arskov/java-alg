package com.github.akovalchuk;

/**
 * Educative.io. Kth Smallest Number in a Sorted Matrix (Hard)
 * 
 * Leetcode. 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};
            int counter = partition(matrix, mid, smallLargePair);
            if (counter < k) {
                lo = smallLargePair[1];
            } else if (counter > k) {
                hi = smallLargePair[0]; 
            } else {
                return smallLargePair[0];
            }
        }
        return lo;
    }

    private static int partition(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length;
        int r = n - 1;
        int c = 0;
        while (r >= 0 && c < n) {
            if (matrix[r][c] > mid) {
                smallLargePair[1] = Math.min(matrix[r][c], smallLargePair[1]);
                r--;
            } else {
                smallLargePair[0] = Math.max(matrix[r][c], smallLargePair[0]);
                count += r + 1;
                c++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 4 }, { 2, 5 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 2);
        System.out.println("Kth smallest number is: " + result);

        int matrix1[][] = { { -5 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix1, 1);
        System.out.println("Kth smallest number is: " + result);

        int matrix2[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix2, 5);
        System.out.println("Kth smallest number is: " + result);

        int matrix3[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        result = KthSmallestInSortedMatrix.findKthSmallest(matrix3, 8);
        System.out.println("Kth smallest number is: " + result);

    }
}
