package com.github.akovalchuk;

/**
 * Educative.io. Path with Maximum Sum (hard) 
 * 
 * Leetcode. 124. Binary Tree Maximum Path Sum
 */
public class TreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int max;

    public static int findMaximumPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = Math.max(left, 0); // skip negative
        right = Math.max(right, 0); // skip negative
        max = Math.max(max, left + root.val + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));
    }

}
