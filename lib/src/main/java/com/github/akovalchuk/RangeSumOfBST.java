package com.github.akovalchuk;

/**
 * Leetcode. 938. Range Sum of BST
 */
public class RangeSumOfBST {
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null || low > high) return 0;
        int r = 0, l = 0, m = 0;
        if (root.val < high) r = rangeSumBST(root.right, low, high);
        if (root.val > low)  l = rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) m = root.val;
        return r + l + m;
    }

    public static void main(String[] args) {
        var tree = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        var r = new RangeSumOfBST();
        System.out.println(r.rangeSumBST(tree, 3, 9) == 15);
        System.out.println(r.rangeSumBST(tree, 5, 25) == 55);
        System.out.println(r.rangeSumBST(tree, 0, 25) == 58);
    }

}
