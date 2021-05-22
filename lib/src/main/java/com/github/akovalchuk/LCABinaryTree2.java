package com.github.akovalchuk;

/**
 * Leetcode. 236. Lowest Common Ancestor of a Binary Tree
 */
public class LCABinaryTree2 {

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

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root, p, q);
        return lca;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (root.val == p.val || root.val == q.val) {
            if (lca == null) lca = root;
            return true;
        }
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if (l && r) {
            lca = root;
        }
        return l || r;
    }

    public static void main(String[] args) {
        /*
         * [3,5,1,6,2,0,8,null,null,7,4] 5 0
         */
        var tree = new TreeNode(3);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(6);
        var p = new TreeNode(2);
        tree.left.right = p;
        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(4);
        tree.right = new TreeNode(1);
        var q = new TreeNode(0);
        tree.right.left = q;
        tree.right.right = new TreeNode(8);

        var sol = new LCABinaryTree2();
        System.out.println(sol.lowestCommonAncestor(tree, p, q));
    }
}
