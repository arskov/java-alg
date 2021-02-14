package com.github.akovalchuk;

/**
 * Find the side length of the biggest black square in a matrix. In each column,
 * black cells start at the bottom of the matrix and count up.
 * 
 * INCOMPLETE!
 */
public class MaxSquareOnMatrix {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) return 0;
        int max = 1;
        int l = 0;
        int r = 0;
        while (l < A.length - 1) {
            int w = r - l + 1;
            int maxSoFar = 0;
            while (A[r] >= w && r < A.length - 1) {
                r++;
                w = r - l + 1;
                int curMax = Math.min(A[r], w);
                if (curMax > maxSoFar) {
                    maxSoFar++;
                }
            }
            max = Math.max(max, maxSoFar);
            l = r;
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new MaxSquareOnMatrix();
        // System.out.println(sol.solution(new int[] {4, 8, 10, 7, 5, 2, 6, 1, 9, 3}));
        // System.out.println(sol.solution(new int[] {1, 2, 3}));
        System.out.println(sol.solution(new int[] {1, 2, 3, 4, 5, 6}));
        // System.out.println(sol.solution(new int[] {6, 5, 4, 3, 2, 1}));
        // System.out.println(sol.solution(new int[] {1, 2, 5, 3, 1, 3}));
        // System.out.println(sol.solution(new int[] {6, 5, 5, 6, 2, 2}));
    }
}
