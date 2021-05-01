package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Educative.io. Kth Smallest Number in M Sorted Lists (Medium)
 * 
 * Leetcode. 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestInMSortedArrays {
    static class Node {
        int val;
        int listId;
        int listIdx;

        Node(int val, int listId, int listIdx) {
            this.val = val;
            this.listId = listId;
            this.listIdx = listIdx;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        if (lists == null || lists.size() == 0)
            return 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.size(); i++) {
            Integer[] list = lists.get(i);
            if (list != null) {
                minHeap.offer(new Node(list[0], i, 0));
            }
        }
        int n = k;
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            n--;
            if (n == 0)
                return curr.val;
            Integer[] list = lists.get(curr.listId);
            int nextIdx = curr.listIdx + 1;
            if (nextIdx < list.length) {
                minHeap.offer(new Node(list[nextIdx], curr.listId, nextIdx));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.println("Kth smallest number is: " + result);
    }

}
