package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode. 95. Unique Binary Search Trees II
 */
public class UniqueBinarySearchTrees2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private static List<TreeNode> helper(int s, int e) {
        if (s > e)
            return Collections.emptyList();
        if (s == e)
            return List.of(new TreeNode(s, null, null));
        List<TreeNode> result = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftList = helper(s, i - 1);
            List<TreeNode> rightList = helper(i + 1, e);
            if (leftList.isEmpty()) {
                for (TreeNode r : rightList) {
                    result.add(new TreeNode(i, null, r));
                }
            } else if (rightList.isEmpty()) {
                for (TreeNode l : leftList) {
                    result.add(new TreeNode(i, l, null));
                }
            } else if (!leftList.isEmpty() && !rightList.isEmpty()) {
                for (TreeNode l : leftList) {
                    for (TreeNode r : rightList) {
                        result.add(new TreeNode(i, l, r));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = generateTrees(3);
        System.out.println(result);
    }

}
