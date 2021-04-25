package com.github.akovalchuk;

import java.util.PriorityQueue;

/**
 * Educative.io. Connect Ropes (easy)
 * 
 * 1167. Minimum Cost to Connect Sticks
 */
public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        if (ropeLengths == null || ropeLengths.length == 0)
            return 0;
        if (ropeLengths.length == 1)
            return ropeLengths[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) {
            pq.offer(ropeLengths[i]);
        }
        int totalSum = 0;
        while (pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            pq.offer(tmp);
            totalSum += tmp;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
