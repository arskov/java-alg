package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;

/**
 * Educative.io. Target Sum (hard)
 * 
 * You are given a set of positive numbers and a target sum ‘S’. Each number
 * should be assigned either a ‘+’ or ‘-’ sign. We need to find the total ways
 * to assign symbols to make the sum of the numbers equal to the target ‘S’.
 */
public class TargetSumWithSigns {

    public int findTargetSubsets(int[] num, int s) {
        if (num == null || num.length == 0)
            return 0;
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return dfs(num, 0, 0, s, memo);
    }

    private int dfs(int[] num, int i, int tmp, int sum, Map<Integer, Map<Integer, Integer>> memo) {
        if (i == num.length) {
            return tmp == sum ? 1 : 0;
        }
        if (memo.containsKey(tmp) && memo.get(tmp).containsKey(i)) {
            return memo.get(tmp).get(i);
        }

        int l = dfs(num, i + 1, tmp - num[i], sum, memo);
        int r = dfs(num, i + 1, tmp + num[i], sum, memo);
        Map<Integer, Integer> mapByIndex = new HashMap<>();
        mapByIndex.put(i, l + r);
        memo.put(tmp, mapByIndex);
        return l + r;
    }

    public static void main(String[] args) {
        TargetSumWithSigns ts = new TargetSumWithSigns();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[] { 1, 2, 7, 1 };
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}
