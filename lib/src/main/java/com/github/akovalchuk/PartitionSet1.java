package com.github.akovalchuk;

/**
 * Educative.io. Minimum Subset Sum Difference (hard)
 * 
 */
public class PartitionSet1 {
    public int canPartition(int[] num) {
        // sum - set_sum() = rem
        // abs( set_sum() - (sum - set_sum()) ) = abs(2 * set_sum() - sum) -> min
        if (num == null || num.length == 0)
            return 0;

        int sum = 0;
        for (int n : num)
            sum += n;

        Integer[][] memo = new Integer[num.length][sum + 1];
        return dfs(num, 0, sum, 0, memo);
    }

    private int dfs(int[] num, int i, int sum, int tmp, Integer[][] memo) {
        if (i == num.length) {
            return Math.abs(2 * tmp - sum);
        }
        if (memo[i][tmp] != null)
            return memo[i][tmp];
        int l = dfs(num, i + 1, sum, tmp + num[i], memo);
        int r = dfs(num, i + 1, sum, tmp, memo);
        memo[i][tmp] = Math.min(l, r);
        return memo[i][tmp];
    }

    public static void main(String[] args) {
        PartitionSet1 ps = new PartitionSet1();
        int[] num = { 1, 2, 3, 9 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 3, 100, 4 };
        System.out.println(ps.canPartition(num));
    }
}
