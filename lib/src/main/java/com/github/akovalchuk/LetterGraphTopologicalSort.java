package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode. 269. Alien Dictionary
 */
public class LetterGraphTopologicalSort {
    
    public String buildOrder(ArrayList<String> words) {

        var graph = new HashMap<Character, Set<Character>>();
        for (var w : words) {
            for (int i = 0; i < w.length(); i++) {
                graph.putIfAbsent(w.charAt(i), new HashSet<>());
            }
        }
        for (int i = 0; i < words.size() - 1; i++) {
            var w1 = words.get(i);
            var w2 = words.get(i + 1);
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
                if (j == w2.length() - 1 && w1.length() > w2.length())
                    return "";
            }
        }

        System.out.println(graph);

        var order = new LinkedList<Character>();
        // char -> color (null - white; 0 - gray; 1 - black)
        var visited = new HashMap<Character, Integer>();
        boolean res = dfs(graph, null, order, visited);
        if (!res) return "";
        var result = new StringBuilder();
        for (var c : order) result.append(c);
        return result.toString();
    }

    private boolean dfs(Map<Character, Set<Character>> graph, Character node, LinkedList<Character> order, Map<Character, Integer> visited) {
        var children = node == null ? graph.keySet() : graph.get(node);
        for (var key : children) {
            if (visited.containsKey(key) && visited.get(key) == 0) return false;
            if (!visited.containsKey(key)) {
                visited.put(key, 0);
                boolean res = dfs(graph, key, order, visited);
                visited.put(key, 1);
                order.addFirst(key);
                if (!res) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("ab");
        list.add("bc");
        list.add("cd");
        list.add("de");
        list.add("ef");
        list.add("fg");
        list.add("gh");
        list.add("hi");
        list.add("ij");
        list.add("jk");
        list.add("kl");
        list.add("lm");
        list.add("mn");
        list.add("no");
        list.add("op");
        list.sort(null);
        for (var w : list) System.out.println(w);
        System.out.println();
        var sol = new LetterGraphTopologicalSort();
        System.out.println(sol.buildOrder(list));

        list.clear();
        list.addAll(List.of("ac","ab","zc","zb"));
        System.out.println(sol.buildOrder(list));
    }

}
