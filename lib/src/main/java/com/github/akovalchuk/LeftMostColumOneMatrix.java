package com.github.akovalchuk;

/**
 * 1428. Leftmost Column with at Least a One
 */
public class LeftMostColumOneMatrix {
    
    public int leftMostColumnWithOne(int[][] binaryMatrix) {
        int rows = binaryMatrix.length;
        int cols = binaryMatrix[0].length;
        int left = -1;
        for (int r = rows - 1; r >= 0; r--) {
            int c = (left == -1) ? cols - 1 : left;
            if (binaryMatrix[r][c] == 1) {
                while (binaryMatrix[r][c] == 1) {
                    left = c;
                    if (left == 0) return 0;
                    c--;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var s = new LeftMostColumOneMatrix();
        int[][] test = {
            {0,0,0,0,0,1,1,1,1,1},
            {0,0,0,1,1,1,1,1,1,1}, // <==
            {0,0,0,0,0,0,1,1,1,1},
            {0,0,0,1,1,1,1,1,1,1}, // <==
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,1},
        };
        System.out.println(s.leftMostColumnWithOne(test));
    }

}
