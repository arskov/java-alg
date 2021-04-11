package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Educative.io. Zigzag Traversal (medium)
 * 
 * Leetcode. 103. Binary Tree Zigzag Level Order Traversal
 */
public class ZigZagTreeTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        boolean reverse = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (reverse) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(level);
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
