package com.github.akovalchuk;

/**
 * Leetcode. 62. Unique Paths
 */
public class GridTraveler {

    /*
        m = 2, n = 3
        0 1 1 1
        0 1 2 3

        m = 3, n = 3
        0 1 1 1
        1 2 2 2
        1 3 0 0 
        1 0 0 0 
    */
    
    public int howManyWaysRecursion(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
        return howManyWaysRecursion(m - 1, n) + howManyWaysRecursion(m, n - 1);
    }

    public int howManyWaysBottomUp(int m, int n) {
        if (m < 0 || n < 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        var sol = new GridTraveler();
        System.out.println(sol.howManyWaysBottomUp(2, 3)); // 3
        System.out.println(sol.howManyWaysRecursion(2, 3)); // 3
        System.out.println(sol.howManyWaysBottomUp(16, 16)); // 155_117_520
        System.out.println(sol.howManyWaysRecursion(16, 16)); // 155_117_520
    }

}
