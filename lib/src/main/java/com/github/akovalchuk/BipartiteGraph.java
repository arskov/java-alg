package com.github.akovalchuk;

/**
 * Leetcode. 785. Is Graph Bipartite?
 */
public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                boolean res = dfs(graph, color, i, -1);
                if (!res) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] color, int node, int parentColor) {
        color[node] = -parentColor;
        for (int next : graph[node]) {
            if (color[next] == 0) {
                boolean res = dfs(graph, color, next, -parentColor);
                if (!res) return false;
            } else if (color[next] != parentColor) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new BipartiteGraph();
        int[][] test1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] test2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(sol.isBipartite(test1)); // false
        System.out.println(sol.isBipartite(test2)); // true
    }
}
