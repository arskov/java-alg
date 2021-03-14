package com.github.akovalchuk;

import java.util.HashSet;

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III
 */
public class LCABinaryTree1650 {

    static class Node {
        public int  val;
        public Node left;
        public Node right;
        public Node parent;

        Node(int val) {
            this.val = val;
        }
    }
    
    public static Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) return null;
        var set = new HashSet<Node>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q) || q.parent == null) return q;
            q = q.parent;
        }
        return q;
    }

    public static void main(String[] args) {
        var node3 = new Node(3);
        var node5 = new Node(5);
        var node1 = new Node(1);
        var node6 = new Node(6);
        var node2 = new Node(2);
        var node7 = new Node(7);
        var node4 = new Node(4);
        var node0 = new Node(0);
        var node8 = new Node(8);
        node3.left = node5;
        node5.parent = node3;
        node3.right = node1;
        node1.parent = node3;
        node1.right = node8;
        node8.parent = node1;
        node1.left = node0;
        node0.parent = node1;
        node5.left = node6;
        node6.parent = node5;
        node5.right = node2;
        node2.parent = node5;
        node2.left = node7;
        node7.parent = node2;
        node2.right = node4;
        node4.parent = node2;
        System.out.println(lowestCommonAncestor(node5, node1).val);
        System.out.println(lowestCommonAncestor(node5, node4).val);
    }

}
