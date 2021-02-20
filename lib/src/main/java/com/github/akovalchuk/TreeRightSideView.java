package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
public class TreeRightSideView {

    static class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var result = new ArrayList<Integer>();
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                var node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        var tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        var sol = new TreeRightSideView();
        System.out.println(sol.rightSideView(tree)); // [5, 8, 4, 1]
    }
}
