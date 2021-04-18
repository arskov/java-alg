package com.github.akovalchuk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Educative.io. Count of Structurally Unique Binary Search Trees (hard)
 * 
 * Leetcode. 96. Unique Binary Search Trees
 */
public class CountUniqueTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int countTrees(int n) {
        return helper(1, n);
    }

    private int helper(int s, int e) {
        if (s > e)
            return 0;
        List<Integer> key = Arrays.asList(s, e);
        if (s == e)
            return 1;
        if (memo.containsKey(key))
            return memo.get(key);
        int sum = 0;
        for (int i = s; i <= e; i++) {
            int left = helper(s, i - 1);
            int right = helper(i + 1, e);
            if (left == 0) {
                sum += right;
            } else if (right == 0) {
                sum += left;
            } else {
                sum += left * right;
            }
        }
        memo.put(key, sum);
        return sum;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count + "\n");
    }
}
