package com.github.akovalchuk;

/**
 * 304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2DImmutable {

    private int[][] mat;
    private int[][] pref;
    private int rows;
    private int cols;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        this.mat = matrix;
        rows = matrix.length;
        if (rows == 0) return;
        cols = matrix[0].length;
        this.pref = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    pref[i][j] = mat[i][j];
                } else {
                    pref[i][j] = pref[i][j - 1] + mat[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (rows == 0) return 0;
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += pref[i][col2] - (col1 == 0 ? 0 : pref[i][col1 - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        var sol = new RangeSumQuery2DImmutable(matrix);
        System.out.println(sol.sumRegion(2, 1, 4, 3));
        System.out.println(sol.sumRegion(1, 1, 2, 2));
        System.out.println(sol.sumRegion(1, 2, 2, 4));
    }
}
