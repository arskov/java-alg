package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode. 113. Path Sum II
 */
public class CountAllPathsWithSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return Collections.emptyList();
        var result = new ArrayList<List<Integer>>();
        dfs(root, new ArrayList<>(), result, 0, targetSum);
        return result;
    }
    
    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result, int pathSum, int targetSum) {
        path.add(node.val);
        pathSum += node.val;
        if (node.left == null && node.right == null && targetSum == pathSum) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (node.left != null) {
            dfs(node.left, path, result, pathSum, targetSum);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, path, result, pathSum, targetSum);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
