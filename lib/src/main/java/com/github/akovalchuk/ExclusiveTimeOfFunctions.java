package com.github.akovalchuk;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode. 636. Exclusive Time of Functions
 */
public class ExclusiveTimeOfFunctions {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int lastTs = 0;
        var stack = new Stack<Integer>();
        for (var log : logs) {
            var parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int ts = Integer.parseInt(parts[2]);
            if ("start".equals(parts[1])) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += ts - lastTs;
                }
                stack.push(id);
                lastTs = ts;
            } else {
                res[stack.pop()] += ts - lastTs + 1;
                lastTs = ts + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new ExclusiveTimeOfFunctions();
        var test1 = List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        System.out.println(Arrays.toString(s.exclusiveTime(1, test1))); // [8]
        var test2 = List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        System.out.println(Arrays.toString(s.exclusiveTime(2, test2))); // [7,1]
    }
}