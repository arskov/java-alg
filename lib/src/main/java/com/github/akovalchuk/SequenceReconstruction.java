package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Educative.io. Reconstructing a Sequence (hard)
 * <p>
 * Given a sequence originalSeq and an array of sequences, write a method to
 * find if originalSeq can be uniquely reconstructed from the array of
 * sequences.
 * 
 * Unique reconstruction means that we need to find if originalSeq is the only
 * sequence such that all sequences in the array are subsequences of it.
 */
public class SequenceReconstruction {

    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        if (sequences == null || sequences.length == 0 || originalSeq == null || originalSeq.length == 0)
            return false;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int[] edge : sequences) {
            for (int i = 0; i < edge.length - 1; i++) {
                int f = edge[i];
                int t = edge[i + 1];
                inDegree.putIfAbsent(f, 0);
                inDegree.putIfAbsent(t, 0);
                graph.putIfAbsent(f, new HashSet<>());
                graph.putIfAbsent(t, new HashSet<>());
                graph.get(f).add(t);
                inDegree.put(t, inDegree.get(t) + 1);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.add(e.getKey());
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        int j = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                return false;
            Integer next = queue.poll();
            order.add(next);
            if (!order.get(j++).equals(next))
                return false;
            Set<Integer> children = graph.get(next);
            if (children != null) {
                for (Integer child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        return order.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
