package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Educative.io. Scheduling Tasks (hard)
 * 
 * Leetcode. 621. Task Scheduler
 */
public class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        if (tasks == null || tasks.length == 0 || k == 0)
            return 0;
        if (k == 1)
            return tasks.length;
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : tasks) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(counter.entrySet());
        LinkedList<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        LinkedList<Character> buf = new LinkedList<>();
        int taskCounter = 0;
        while (!maxHeap.isEmpty()) {
            int n = k + 1;
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                Map.Entry<Character, Integer> tmp = maxHeap.poll();
                taskCounter++;
                buf.add(tmp.getKey());
                if (tmp.getValue() > 1) {
                    tmp.setValue(tmp.getValue() - 1);
                    queue.add(tmp);
                }
            }
            maxHeap.addAll(queue);
            queue.clear();
            if (!maxHeap.isEmpty()) {
                taskCounter += n;
                for (int i = 0; i < n; i++) {
                    buf.add('-');
                }
            }
        }
        System.out.println(buf);
        return taskCounter;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }

}
