package com.github.akovalchuk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Educative.io. Alien Dictionary (hard)
 * 
 * Leetcode. 269. Alien Dictionary
 * 
 * There is a dictionary containing words from an alien language for which we
 * don’t know the ordering of the alphabets. Write a method to find the correct
 * order of the alphabets in the alien language. It is given that the input is a
 * valid dictionary and there exists an ordering among its alphabets.
 */
public class AlienDictionary {

    public static String findOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            int minLen = Math.min(words[i - 1].length(), words[i].length());
            while (j < minLen && words[i - 1].charAt(j) == words[i].charAt(j))
                j++;
            char from = words[i - 1].charAt(j);
            char to = words[i].charAt(j);
            Set<Character> children = graph.getOrDefault(from, new HashSet<>());
            children.add(to);
            graph.put(from, children);
        }
        StringBuilder order = new StringBuilder();
        Map<Character, Integer> visited = new HashMap<>();
        boolean res = dfs(graph, null, order, visited);
        order.reverse();
        return !res ? "" : order.toString();
    }

    private static boolean dfs(Map<Character, Set<Character>> graph, Character node, StringBuilder order,
            Map<Character, Integer> visited) {
        Set<Character> children = node == null ? graph.keySet() : graph.get(node);
        if (children != null) {
            for (Character child : children) {
                if (visited.containsKey(child)) {
                    if (visited.get(child) == 0)
                        return false;
                    else
                        continue;
                }
                visited.put(child, 0);
                dfs(graph, child, order, visited);
                visited.put(child, 1);
                order.append(child);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
