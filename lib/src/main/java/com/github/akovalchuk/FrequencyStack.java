package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Frequency Stack (hard)
 * 
 * Leetcode. 895. Maximum Frequency Stack
 */
public class FrequencyStack {

    private static class Node {
        int num;
        int seq;
        int cnt;

        Node(int num, int seq, int cnt) {
            this.num = num;
            this.seq = seq;
            this.cnt = cnt;
        }
    }

    private int sequence = 0;
    private Map<Integer, Integer> counter = new HashMap<>();
    private PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> {
        if (a.cnt == b.cnt) {
            return b.seq - a.seq;
        }
        return b.cnt - a.cnt;
    });

    public void push(int num) {
        counter.put(num, counter.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Node(num, sequence++, counter.get(num)));
    }

    public int pop() {
        Node tmp = maxHeap.poll();
        int num = tmp.num;
        if (counter.get(num) > 1) {
            counter.put(num, counter.get(num) + 1);
        } else {
            counter.remove(num);
        }
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
