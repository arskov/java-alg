package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class CpuTaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        var dic = new HashMap<Character, Integer>();
        for (char t : tasks) {
            dic.compute(t, (k, v) -> v == null ? 1 : v + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(dic.entrySet());
        var result = new LinkedList<Character>();
        var tmp = new LinkedList<Map.Entry<Character, Integer>>();
        while (!pq.isEmpty()) {
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    tmp.addLast(pq.poll());
                    result.addLast(tmp.peekLast().getKey());
                } else {
                    result.addLast('-');
                }
            }
            while (!tmp.isEmpty()) {
                var elem = tmp.pollLast();
                if (elem.getValue() > 1) {
                    elem.setValue(elem.getValue() - 1);
                    pq.offer(elem);
                }
            }
        }
        System.out.println(result);
        while (result.peekLast() == '-') result.pollLast();
        System.out.println(result);
        return result.size();
    }

    public static void main(String[] args) {
        var sol = new CpuTaskScheduler();
        System.out.println(sol.leastInterval(new char[] {'A','A','A','B','B','B'}, 2)); // 8
        System.out.println(sol.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2)); // 16
        System.out.println(sol.leastInterval(new char[] {'A','A','A','B','B','B','C','C','C','D','D','E'}, 2)); // 12
        System.out.println(sol.leastInterval(new char[] {'A','A','A','B','B','C','C','C','D','D','E'}, 2)); // 11
    }
}
