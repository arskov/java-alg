package com.github.akovalchuk;

/**
 * Educative.io Path With Given Sequence (medium)
 * 
 * Leetcode. 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 */
public class PathWithGivenSequence {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null || sequence == null)
            return false;
        return find(root, sequence, 0);
    }

    private static boolean find(TreeNode root, int[] arr, int pos) {
        if (root == null)
            return false;
        if (pos == arr.length)
            return false;
        if (root.val != arr[pos])
            return false;
        if (root.left == null && root.right == null && pos == arr.length - 1)
            return true;
        boolean result = false;
        if (root.left != null)
            result = result || find(root.left, arr, pos + 1);
        if (root.right != null)
            result = result || find(root.right, arr, pos + 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }

}
