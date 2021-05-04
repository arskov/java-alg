package com.github.akovalchuk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Educative.io. Topological Sort (medium)
 */
public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        LinkedList<Integer> sortedOrder = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> children = graph.getOrDefault(from, new HashSet<>());
            children.add(to);
            graph.put(from, children);
        }
        Map<Integer, Integer> visited = new HashMap<>();
        dfs(graph, null, sortedOrder, visited);
        return sortedOrder;
    }

    /**
     * Performes the DFS on a graph with coloring (white(null), gray(0), black(1)), 
     * returns false if the graph contains a cycle.
     * 
     * @param graph
     * @param node
     * @param order
     * @param visited
     * @return false if the graph conteains a cycle
     */
    private static boolean dfs(Map<Integer, Set<Integer>> graph, Integer node, LinkedList<Integer> order,
            Map<Integer, Integer> visited) {
        Set<Integer> children = node == null ? graph.keySet() : graph.get(node);
        if (children != null) {
            for (Integer child : children) {
                if (visited.containsKey(child)) {
                    if (visited.get(child) == 0)
                        return false;
                    else
                        continue;
                }
                visited.put(child, 0);
                boolean result = dfs(graph, child, order, visited);
                if (!result) return false;
                visited.put(child, 1);
                order.addFirst(child);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
