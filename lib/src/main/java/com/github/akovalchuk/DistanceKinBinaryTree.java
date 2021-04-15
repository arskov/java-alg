package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Leetcode. 863. All Nodes Distance K in Binary Tree
 */
public class DistanceKinBinaryTree {

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

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null)
            return List.of();
        var result = new ArrayList<Integer>();
        var parentMap = new HashMap<TreeNode, TreeNode>();
        var visited = new HashSet<TreeNode>();
        dfs(root, null, parentMap);
        var q = new ArrayDeque<TreeNode>();
        visited.add(target);
        q.offer(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                var curr = q.poll();
                if (K == 0) {
                    result.add(curr.val);
                } else {
                    if (curr.left != null && !visited.contains(curr.left)) {
                        q.offer(curr.left);
                        visited.add(curr.left);
                    }
                    if (curr.right != null && !visited.contains(curr.right)) {
                        q.offer(curr.right);
                        visited.add(curr.right);
                    }
                    if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                        q.offer(parentMap.get(curr));
                        visited.add(parentMap.get(curr));
                    }
                }
            }
            if (K == 0)
                break;
            K--;
        }
        return result;
    }

    private static void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;
        parentMap.put(node, parent);
        dfs(node.left, node, parentMap);
        dfs(node.right, node, parentMap);
    }

    public static void main(String[] args) {
        // TODO: test
    }
}
