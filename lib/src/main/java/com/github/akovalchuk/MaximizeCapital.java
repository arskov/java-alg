package com.github.akovalchuk;

import java.util.PriorityQueue;

/**
 * Educative.io. Maximize Capital (hard)
 * 
 * Leetcode. 502. IPO
 */
public class MaximizeCapital {

    public static int findMaximumCapital(int[] capitals, int[] profits, int numberOfProjects, int initialCapital) {
        if (capitals == null || profits == null) return 0;
        int n = capitals.length;
        var minCap = new PriorityQueue<Integer>(n, (a, b) -> capitals[a] - capitals[b]);
        var maxPro = new PriorityQueue<Integer>(n, (a, b) -> profits[b] - profits[a]);
        for (int i = 0; i < n; i++) {
            minCap.offer(i);
        }
        int capital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            while (!minCap.isEmpty() && capitals[minCap.peek()] <= capital) {
                maxPro.offer(minCap.poll());
            }
            if (maxPro.isEmpty()) break;
            capital += profits[maxPro.poll()];
        }
        return capital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
