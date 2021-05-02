package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode. 39. Combination Sum
 * <p>
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.The same
 * number may be chosen from candidates an unlimited number of times. Two
 * combinations are unique if the frequency of at least one of the chosen
 * numbers is different. It is guaranteed that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return Collections.emptyList();
        var result = new ArrayList<List<Integer>>();
        dfs(candidates, 0, target, new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int[] nums, int start, int sum, LinkedList<Integer> tmp, List<List<Integer>> result) {
        if (sum == 0) {
            var res = new ArrayList<Integer>(tmp);
            result.add(res);
            return;
        }
        if (sum < 0)
            return;
        for (int j = start; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(nums, j, sum - nums[j], tmp, result);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
        System.out.println(combinationSum(new int[] { 1 }, 1));
    }
}
