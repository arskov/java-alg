package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Educative.io. Smallest Number Range (Hard)
 * 
 * Leetcode. 632. Smallest Range Covering Elements from K Lists
 */
public class SmallestRange {
    private static class Node {
        int val;
        int listIdx;
        int idx;

        Node(int val, int listIdx, int idx) {
            this.val = val;
            this.listIdx = listIdx;
            this.idx = idx;
        }
    }

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int maxSoFar = 0;
        for (int i = 0; i < lists.size(); i++) {
            Integer[] list = lists.get(i);
            if (list != null && list.length > 0) {
                minHeap.offer(new Node(list[0], i, 0));
                maxSoFar = Math.max(maxSoFar, list[0]);
            }
        }
        int minLen = Integer.MAX_VALUE;
        int[] result = { -1, -1 };
        while (minHeap.size() >= lists.size()) {
            Node lo = minHeap.poll();
            if (maxSoFar - lo.val < minLen) {
                result[0] = lo.val;
                result[1] = maxSoFar;
                minLen = maxSoFar - lo.val;
            }
            Integer[] list = lists.get(lo.listIdx);
            int nextIdx = lo.idx + 1;
            if (list != null && nextIdx < list.length) {
                int nextVal = list[nextIdx];
                minHeap.offer(new Node(nextVal, lo.listIdx, nextIdx));
                maxSoFar = Math.max(maxSoFar, nextVal);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
