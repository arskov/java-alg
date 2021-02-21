package com.github.akovalchuk;

import java.util.LinkedList;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LCABinaryTree1 {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null || root == p || root == q)
            return root;
        var list1 = new LinkedList<TreeNode>();
        var list2 = new LinkedList<TreeNode>();
        search(root, p, list1);
        search(root, q, list2);
        TreeNode prev1 = null;
        TreeNode prev2 = null;
        var it1 = list1.listIterator();
        var it2 = list2.listIterator();
        while (it1.hasNext() && it2.hasNext()) {
            var node1 = it1.next();
            var node2 = it2.next();
            if (node1.val != node2.val) {
                break;
            }
            prev1 = node1;
            prev2 = node2;
        }
        return prev1;
    }

    private boolean search(TreeNode root, TreeNode need, LinkedList<TreeNode> list) {
        list.add(root);
        if (root.val == need.val) {
            return true;
        }
        boolean res = false;
        if (root.left != null) {
            res = search(root.left, need, list);
            if (!res && !list.isEmpty())
                list.removeLast();
        }
        if (res)
            return true;
        if (root.right != null) {
            res = search(root.right, need, list);
            if (!res && !list.isEmpty())
                list.removeLast();
        }
        return res;
    }

    public static void main(String[] args) {
        /*
         * [3,5,1,6,2,0,8,null,null,7,4] 
         * 5
         * 0
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

        var sol = new LCABinaryTree1();
        System.out.println(sol.lowestCommonAncestor(tree, p, q));
    }

}
