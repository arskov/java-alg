package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode. 216. Combination Sum III
 * 
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 *  - Only numbers 1 through 9 are used. 
 *  - Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 */
public class CombinationSum1 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        return dfs(1, k, n);
    }

    private static List<List<Integer>> dfs(int num, int k, int target) {
        if (target == 0 && k == 0) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            res.add(tmp);
            return res;
        }
        if (target < 0 || k < 0 || num > 9)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> left = dfs(num + 1, k, target);
        if (left != null) {
            for (List<Integer> list : left) {
                res.add(list);
            }
        }
        List<List<Integer>> right = dfs(num + 1, k - 1, target - num);
        if (right != null) {
            for (List<Integer> list : right) {
                list.add(num);
                res.add(list);
            }
        }
        return res.isEmpty() ? null : res;
    }

    public static void main(String[] args) {
        var result = combinationSum3(3, 7);
        System.out.println(result);
    }

}
