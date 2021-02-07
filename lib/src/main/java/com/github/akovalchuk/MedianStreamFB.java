package com.github.akovalchuk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MedianStreamFB {

    int[] findMedian(int[] arr) {
        // Write your code here
        if (arr == null || arr.length <= 1)
            return arr;
        int[] res = new int[arr.length];
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            sorted.offer(arr[i]);
            int len = sorted.size();
            for (int j = 1; j <= len / 2; j++) {
                tmp.add(sorted.poll());
            }
            if (len % 2 == 0) {
                res[i] = (tmp.peekLast() + sorted.peek()) / 2;
            } else {
                res[i] = sorted.peek();
            }
            while (!tmp.isEmpty())
                sorted.offer(tmp.pollLast());
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new MedianStreamFB();
        System.out.println(Arrays.toString(sol.findMedian(new int[] {2, 4, 7, 1, 5, 3})));
    }
}
