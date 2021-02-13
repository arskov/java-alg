package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* 
314. Binary Tree Vertical Order Traversal
*/
public class BinaryTreeVerticalOrder {

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

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return List.of();
        var d = new TreeMap<Integer, List<Integer>>();
        var q = new ArrayDeque<Pair>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            var pair = q.poll();
            if (d.containsKey(pair.col)) {
                d.get(pair.col).add(pair.node.val);
            } else {
                var tmp = new ArrayList<Integer>();
                tmp.add(pair.node.val);
                d.put(pair.col, tmp);
            }
            if (pair.node.left != null) {
                q.offer(new Pair(pair.node.left, pair.col - 1));
            }
            if (pair.node.right != null) {
                q.offer(new Pair(pair.node.right, pair.col + 1));
            }
        }
        var result = new ArrayList<List<Integer>>();
        for (var e : d.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }

}
