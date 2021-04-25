package com.github.akovalchuk;

import java.util.PriorityQueue;

/**
 * <p>
 * Educative.io. Kth Largest Number in a Stream (medium)
 * <p>
 * Leetcode. 703. Kth Largest Element in a Stream
 */
public class KthLargestNumberInStream {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        for (int n : nums) {
            this.add(n);
        }
    }

    public int add(int num) {
        pq.offer(num);
        if (pq.size() > k)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
