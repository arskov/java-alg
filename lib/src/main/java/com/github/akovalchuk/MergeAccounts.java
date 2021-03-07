package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 721. Accounts Merge
 */
public class MergeAccounts {
    
    static class Node {
        String name;
        Node(String name) {
            this.name = name;
        }
    }
    
    private Map<String, List<Node>> revMap = new HashMap<>();
    private Map<Node, List<String>> dirMap = new HashMap<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) return Collections.emptyList();
        for (var acc : accounts) {
            var name = acc.get(0);
            var node = new Node(name);
            for (int i = 1; i < acc.size(); i++) {
                var email = acc.get(i);
                if (!revMap.containsKey(email)) {
                    revMap.put(email, new ArrayList<>());
                }
                revMap.get(email).add(node);
                if (!dirMap.containsKey(node)) {
                    dirMap.put(node, new ArrayList<>());
                }
                dirMap.get(node).add(email);
            }
        }
        var vis = new HashSet<Node>();
        var result = new ArrayList<List<String>>();
        var set = new TreeSet<String>();
        for (var e : dirMap.keySet()) {
            if (!vis.contains(e)) {
                set.clear();
                dfs(e, vis, set);
                var tmp = new ArrayList<String>();
                tmp.add(e.name);
                tmp.addAll(set);
                result.add(tmp);
            }
        }
        return result;
    }
    
    private void dfs(Node root, Set<Node> vis, Set<String> set) {
        if (vis.contains(root)) return;
        vis.add(root);
        var emails = dirMap.get(root);
        for (String email : emails) {
            set.add(email);
            var nextNodes = revMap.get(email);
            for (Node node : nextNodes) {
                dfs(node, vis, set);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> test = List.of(
            List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
            List.of("John","johnsmith@mail.com","john00@mail.com"),
            List.of("Mary","mary@mail.com"),
            List.of("John","johnnybravo@mail.com")
        );
        var s = new MergeAccounts();
        var res = s.accountsMerge(test);
        for (var e : res) {
            System.out.println(e);
        }
    }
    
}
