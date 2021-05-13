package com.github.akovalchuk;

/**
 * Educative.io. Number factors
 * <p>
 * Given a number ‘n’, implement a method to count how many possible ways there
 * are to express ‘n’ as the sum of 1, 3, or 4.
 * <p>
 * Write a function to calculate the nth Fibonacci number. Fibonacci numbers are
 * a series of numbers in which each number is the sum of the two preceding
 * numbers. First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8
 * <p>
 * Given a stair with ‘n’ steps, implement a method to count how many possible
 * ways are there to reach the top of the staircase, given that, at every step
 * you can either take 1 step, 2 steps, or 3 steps.
 */
public class NumberFactors {

    public static int countWays(int n) {
        if (n < 0)
            return -1;
        if (n < 3)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 4] + dp[i - 3] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
        System.out.println(countWays(6));
    }
}
