package com.github.akovalchuk;

import java.util.PriorityQueue;

/**
 * Educative.io. Merge K Sorted Lists (medium)
 * 
 * Leetcode. 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static ListNode merge(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        ListNode resultNext = null;
        var pq = new PriorityQueue<ListNode>((a, b) -> a.value - b.value);
        for (var list : lists) {
            if (list != null)
                pq.offer(list);
        }
        while (!pq.isEmpty()) {
            var node = pq.poll();
            if (result == null) {
                result = node;
            }
            if (resultNext != null) {
                resultNext.next = node;
            }
            resultNext = node;
            if (node.next != null)
                pq.offer(node.next);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
    }
}
