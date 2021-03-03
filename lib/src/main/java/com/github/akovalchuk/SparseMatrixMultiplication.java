package com.github.akovalchuk;

import java.util.Arrays;

/**
 * 311. Sparse Matrix Multiplication
 */
public class SparseMatrixMultiplication {

    public int[][] multiplyBruteForse(int[][] A, int[][] B) {
        if (A == null || B == null || A[0].length != B.length) return null;
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    res[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return res;
    }

    public int[][] multiplyOptimally(int[][] A, int[][] B) {
        if (A == null || B == null || A[0].length != B.length) return null;
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B.length; j++) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return res;
    }

    private static void printMat(int[][] mat) {
        if (mat == null) System.out.println("Null matrix");
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {
        var s = new SparseMatrixMultiplication();
        int[][] A = {
            {1,0,0},
            {-1,0,3}
        };
        int [][] B = {
            {7,0,0},
            {0,0,0},
            {0,0,1}
        };
        printMat(s.multiplyBruteForse(A, B));
        printMat(s.multiplyOptimally(A, B));
    }
}
