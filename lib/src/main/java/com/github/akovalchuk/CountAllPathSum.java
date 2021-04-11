package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Educative.io. Count Paths for a Sum (medium)
 * 
 * Leetcode. 437. Path Sum III
 * 
 * Current solution is not optimal. Shoulf use prefix sums
 */
public class CountAllPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countPaths(TreeNode root, int S) {
        if (root == null)
            return 0;
        return dfs(root, new ArrayList<>(), S);
    }

    private static int dfs(TreeNode node, List<Integer> path, int target) {
        path.add(node.val);
        int pathSum = 0;
        int pathCount = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            pathSum += path.get(i);
            if (pathSum == target)
                pathCount++;
        }
        if (node.left != null) {
            pathCount += dfs(node.left, path, target);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            pathCount += dfs(node.right, path, target);
            path.remove(path.size() - 1);
        }
        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + countPaths(root, 11));
    }
}
