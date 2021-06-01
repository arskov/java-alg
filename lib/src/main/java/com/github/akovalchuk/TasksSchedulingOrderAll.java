package com.github.akovalchuk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Educative.io. All Tasks Scheduling Orders (hard)
 * 
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
 * prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, write a method to
 * print all possible ordering of tasks meeting all prerequisites.
 */
public class TasksSchedulingOrderAll {
    public static void printOrders(int tasks, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            int f = edge[0];
            int t = edge[1];
            inDegree.put(t, inDegree.get(t) + 1);
            graph.get(f).add(t);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.offer(e.getKey());
            }
        }

        LinkedList<Integer> order = new LinkedList<>();

        printAllTopologicalSorts(graph, inDegree, queue, order);
    }

    private static void printAllTopologicalSorts(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> inDegree,
            LinkedList<Integer> queue, LinkedList<Integer> order) {

        if (!queue.isEmpty()) {
            for (Integer node : queue) {
                order.add(node);
                LinkedList<Integer> queueNext = new LinkedList<>();
                queueNext.addAll(queue);
                queueNext.remove(node);
                Set<Integer> children = graph.get(node);
                for (Integer child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        queueNext.offer(child);
                    }
                }
                printAllTopologicalSorts(graph, inDegree, queueNext, order);
                order.remove(node);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        if (inDegree.size() == order.size()) {
            System.out.println(order);
        }

    }

    public static void main(String[] args) {
        printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        printOrders(4, new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 1, 4 },
                new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}
