package com.github.akovalchuk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Educative.io. Tasks Scheduling (medium)
 * <p>
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
 * prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, find out if it is
 * possible to schedule all the tasks.
 * 
 */
public class TasksScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            Set<Integer> children = graph.getOrDefault(from, new HashSet<>());
            children.add(to);
            graph.put(from, children);
        }
        // null - white, 0 - gray, 1 - black
        Map<Integer, Integer> visited = new HashMap<>();
        return dfs(graph, null, visited);
    }

    private static boolean dfs(Map<Integer, Set<Integer>> graph, Integer node, Map<Integer, Integer> visited) {
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
                boolean res = dfs(graph, child, visited);
                if (!res)
                    return false;
                visited.put(child, 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        boolean result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }

}
