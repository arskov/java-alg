package com.github.akovalchuk;

import java.util.ArrayDeque;

/**
 * Leetcode. 547. Number of Provinces
 */
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
        int n = isConnected.length;
        var queue = new ArrayDeque<Integer>();
        int component = 0;
        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                component -= 1;
                queue.offer(i);
                isConnected[i][i] = component;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[node][j] == 1) {
                            isConnected[node][j] = component;
                            isConnected[j][node] = component;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return component == 0 ? 0 : -component;
    }

    public static void main(String[] args) {
        int[][] test = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        System.out.println(findCircleNum(test));
    }
    
}
