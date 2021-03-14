package com.github.akovalchuk;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LCABinarySearchTree235 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val)) return root;
        if (p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }

    public static void main(String[] args) {
        var tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(10);
        System.out.println(lowestCommonAncestor(tree, tree.right.left, tree.right.right));
    }

}
