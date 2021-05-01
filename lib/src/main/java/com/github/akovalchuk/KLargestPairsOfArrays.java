package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Educative.io. K Pairs with Largest Sums (Hard)
 * 
 * Leetcode. 373. Find K Pairs with Smallest Sums
 */
public class KLargestPairsOfArrays {
    private static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int sum() {
            return a + b;
        }
    }

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return Collections.emptyList();
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum() - b.sum());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Pair newPair = new Pair(nums1[i], nums2[j]);
                if (minHeap.size() < k) {
                    minHeap.offer(newPair);
                } else if (newPair.sum() > minHeap.peek().sum()) {
                    minHeap.poll();
                    minHeap.offer(newPair);
                }
            }
        }
        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            result.add(new int[] { pair.a, pair.b });
        }
        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
        System.out.println();
    }
}
