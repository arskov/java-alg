package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Leetcode. 1233. Remove Sub-Folders from the Filesystem
 */
public class RemoveSubfolders1 {
    public static class Node {
        String name;
        Set<Node> children = new HashSet<>();

        Node(String name) {
            this.name = name;
        }

        public int hashCode() {
            return Objects.hash(this.name);
        }

        public boolean equals(Object other) {
            if (other == null)
                return false;
            if (other instanceof Node) {
                Node o = (Node) other;
                return o.name.equals(this.name);
            }
            return false;
        }

        public String toString() {
            var sb = new StringBuilder();
            sb.append(this.name).append(" -> ").append(this.children.toString());
            return sb.toString();
        }
    }

    public static List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length == 0)
            return List.of();
        var tree = new Node("");
        for (var f : folder) {
            if ("/".equals(f)) return List.of();
            String[] parts = f.split("/");
            populate(tree, parts, 1);
        }
        var result = new ArrayList<String>();
        flatten(tree, new LinkedList<>(), result);
        return result;
    }

    private static void populate(Node root, String[] parts, int i) {
        if (i == parts.length) {
            return;
        }
        var currPath = parts[i];
        if (!root.children.isEmpty()) {
            for (var child : root.children) {
                if (currPath.equals(child.name)) {
                    if (child.children.isEmpty()) {
                        return;
                    }
                    if (parts.length - 1 == i) {
                        child.children.clear();
                        return;
                    }
                    populate(child, parts, i + 1);
                    return;
                }
            }
        }
        var next = new Node(currPath);
        root.children.add(next);
        populate(next, parts, i + 1);
    }

    private static void flatten(Node root, LinkedList<Node> acc, List<String> res) {
        if (root.children.isEmpty()) {
            var it = acc.iterator();
            var sb = new StringBuilder();
            sb.append("/");
            while (it.hasNext()) {
                sb.append(it.next().name);
                if (it.hasNext())
                    sb.append("/");
            }
            res.add(sb.toString());
        }
        for (var child : root.children) {
            acc.add(child);
            flatten(child, acc, res);
            acc.removeLast();
        }
    }

    public static void main(String[] args) {
        String[] test1 = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(test1));
        String[] test2 = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders(test2));
        String[] test3 = {"/","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders(test3));
    }
}
