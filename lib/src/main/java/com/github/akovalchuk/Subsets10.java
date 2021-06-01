package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode. 78. Subsets
 */
public class Subsets10 {
    
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return List.of(List.of());
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            var tmp = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                int idx = 1 << j;
                if ((i & idx) == idx) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        var solution = new Subsets10();
        System.out.println(solution.subsets(new int[] {1,2,3}));
    }

}
