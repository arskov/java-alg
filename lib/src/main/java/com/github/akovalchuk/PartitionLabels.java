package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode. 763. Partition Labels
 */
public class PartitionLabels {
    /**
    "a b a bcbacadefegdehijhklij"
    
    intervals 0,0; 1,1
    2, 23
    0, 0
    1, 1
    2 -> a => 0 -> interval 0 - 2
    
    */
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.isEmpty()) return Collections.emptyList();
        var indexes = new HashMap<Character, Integer>();
        var intervals = new ArrayDeque<List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexes.containsKey(c)) {
                int prevIdx = indexes.get(c);
                while (!intervals.isEmpty()) {
                    var lastInterval = intervals.peekLast();
                    if (lastInterval.get(0) <= prevIdx && prevIdx <= lastInterval.get(1)) {
                        lastInterval.set(1, i);
                        break;
                    }
                    intervals.pollLast();
                }
            } else {
                indexes.put(c, i);
                intervals.addLast(Arrays.asList(i, i));
            }
        }
        var result = new ArrayList<Integer>();
        for (var interval : intervals) result.add(interval.get(1) - interval.get(0) + 1);
        return result;
    }
    
}
