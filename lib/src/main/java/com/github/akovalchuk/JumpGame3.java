package com.github.akovalchuk;

/**
 * 1306. Jump Game III
 */
public class JumpGame3 {

    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0 || start < 0 || start > arr.length - 1) return false;
        var visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    
    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start > arr.length - 1 || visited[start]) return false;
        visited[start] = true;
        int val = arr[start];
        if (val == 0) {
            return true;
        }
        boolean left = dfs(arr, start - val, visited);
        boolean right = dfs(arr, start + val, visited);
        return left || right;
    }

    public static void main(String[] args) {
        var game = new JumpGame3();
        int[] test1 = {4,2,3,0,3,1,2};
        System.out.println(game.canReach(test1, 5));
        int[] test2 = {4,2,3,0,3,1,2};
        System.out.println(game.canReach(test2, 0));
        int[] test3 = {3,0,2,1,2};
        System.out.println(game.canReach(test3, 2));
    }
}
