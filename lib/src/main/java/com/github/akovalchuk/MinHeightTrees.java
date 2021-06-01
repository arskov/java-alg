package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Educative.io. Minimum Height Trees (hard)
 * 
 * We are given an undirected graph that has characteristics of a k-ary tree. In
 * such a graph, we can choose any node as the root to make a k-ary tree. The
 * root (or the tree) with the minimum height will be called Minimum Height Tree
 * (MHT). There can be multiple MHTs for a graph. In this problem, we need to
 * find all those roots which give us MHTs. Write a method to find all MHTs of
 * the given graph and return a list of their roots.
 */
public class MinHeightTrees {

    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> resultTreeRoots = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            graph.put(i, new HashSet<>());
            edgeCount.put(i, 0);
        }
        for (int[] edge : edges) {
            int f = edge[0];
            int t = edge[1];
            graph.get(f).add(t);
            graph.get(t).add(f);
            edgeCount.put(f, edgeCount.get(f) + 1);
            edgeCount.put(t, edgeCount.get(t) + 1);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> edge : edgeCount.entrySet()) {
            if (edge.getValue() == 1) {
                queue.add(edge.getKey());
            }
        }
        while (true) {
            if (edgeCount.size() == 1 || edgeCount.size() == 2) {
                resultTreeRoots.addAll(edgeCount.keySet());
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                edgeCount.remove(node);
                Set<Integer> children = graph.get(node);
                if (children != null) {
                    for (Integer child : children) {
                        edgeCount.put(child, edgeCount.get(child) - 1);
                        if (edgeCount.get(child) == 1) {
                            queue.add(child);
                        }
                    }
                }
            }
        }
        return resultTreeRoots;
    }

    public static void main(String[] args) {
        List<Integer> result = MinHeightTrees.findTrees(5,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
        System.out.println("Roots of MHTs: " + result);
    
        result = MinHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
        System.out.println("Roots of MHTs: " + result);
    
        result = MinHeightTrees.findTrees(4,
            new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
        System.out.println("Roots of MHTs: " + result);
      }

}
