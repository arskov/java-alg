package com.github.akovalchuk;

/**
 * 124. Binary Tree Maximum Path Sum
 */
public class TreeMaxPathSum {

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

    private int max;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int pathWithRoot = root.val + l + r;
        int returnPath = Math.max(root.val, Math.max(root.val + l, root.val + r));
        max = Math.max(max, Math.max(returnPath, pathWithRoot));
        return returnPath;
    }

    public static void main(String[] args) {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        var tree = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        var sol = new TreeMaxPathSum();
        System.out.println(sol.maxPathSum(tree)); // 48
    }
}
