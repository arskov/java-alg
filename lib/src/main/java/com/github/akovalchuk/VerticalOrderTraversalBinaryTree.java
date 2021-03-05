package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 */
public class VerticalOrderTraversalBinaryTree {

    private static class TreeNode {
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var queue = new PriorityQueue<int[]>((a, b) -> {
            // int[] {row, col, val}
            if (a[1] == b[1]) { // col
                if (a[0] == b[0]) { // row 
                    return Integer.compare(a[2], b[2]); // values
                }
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        helper(root, 0, 0, queue);
        var result = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()) {
            var layer = new ArrayList<Integer>();
            int[] node = queue.poll();
            layer.add(node[2]);
            while (!queue.isEmpty() && queue.peek()[1] == node[1]) {
                int[] tmp = queue.poll();
                layer.add(tmp[2]);
            }
            result.add(layer);
        }
        return result;
    }
    
    private void helper(TreeNode root, int row, int col, PriorityQueue<int[]> queue) {
        if (root == null) return;
        helper(root.left, row + 1, col - 1, queue);
        queue.offer(new int[] {row, col, root.val});
        helper(root.right, row + 1, col + 1, queue);
    }

    public static void main(String[] args) {
        var s = new VerticalOrderTraversalBinaryTree();
        var testTree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)));
        System.out.println(s.verticalTraversal(testTree));
    }
}
