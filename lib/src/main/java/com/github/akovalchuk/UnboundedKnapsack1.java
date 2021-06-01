package com.github.akovalchuk;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Educative.io. Unbounded Knapsack
 * 
 * Given the weights and profits of ‘N’ items, we are asked to put these items
 * in a knapsack that has a capacity ‘C’. The goal is to get the maximum profit
 * from the items in the knapsack. The only difference between the 0/1 Knapsack
 * problem and this problem is that we are allowed to use an unlimited quantity
 * of an item.
 */
public class UnboundedKnapsack1 {

    private static class Item implements Comparable<Item> {
        int profit;
        int weight;
        int idx;

        Item(int profit, int weight, int idx) {
            this.profit = profit;
            this.weight = weight;
            this.idx = idx;
        }

        public int compareTo(Item other) {
            double a = (double) this.profit / this.weight;
            double b = (double) other.profit / other.weight;
            if (a - b > 0) {
                return 1;
            } else if (a - b < 0) {
                return -1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return "[ w = " + this.weight + " p = " + this.profit + " i = " + this.idx + " p/w = " + (double) this.profit / this.weight + "]";
        }
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (profits == null || weights == null || profits.length != weights.length)
            return 0;
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < profits.length; i++) {
            pq.offer(new Item(profits[i], weights[i], i));
        }
        int current = 0;
        int profit = 0;
        while (current < capacity && !pq.isEmpty()) {
            if (pq.peek().weight > capacity - current) {
                pq.poll();
                continue;
            }
            current += pq.peek().weight;
            profit += pq.peek().profit;
        }
        return profit;
    }

    public static void main(String[] args) {
        UnboundedKnapsack1 ks = new UnboundedKnapsack1();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }

}
