package com.github.akovalchuk;

/**
 * Educative.io. Equal Subset Sum Partition (medium)
 * 
 * Leetcode. 416. Partition Equal Subset Sum
 * 
 */
public class PartitionSet {
    static boolean canPartition(int[] num) {
        if (num == null || num.length == 0)
            return false;
        int sum = 0;
        for (int n : num)
            sum += n;
        if (sum % 2 != 0)
            return false;
        Boolean[][] memo = new Boolean[num.length + 1][sum / 2 + 1];
        return dfs(num, 0, sum / 2, memo);
    }

    static boolean dfs(int[] num, int i, int target, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (target < 0 || (target > 0 && i == num.length))
            return false;
        if (memo[i][target] != null)
            return memo[i][target];
        boolean l = dfs(num, i + 1, target - num[i], memo);
        if (l) {
            memo[i][target] = l;
            return l;
        }
        boolean r = dfs(num, i + 1, target, memo);
        memo[i][target] = l || r;
        return l || r;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1, 2, 3, 4}));
        System.out.println(canPartition(new int[] {1, 1, 3, 4, 7}));
        System.out.println(canPartition(new int[] {2, 3, 4, 6}));
    }
}
