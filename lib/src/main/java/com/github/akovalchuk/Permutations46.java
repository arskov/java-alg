package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode. 46. Permutations
 */
public class Permutations46 {

    private void generate(List<List<Integer>> out, int[] nums, int pos, int size) {
        if (pos == size) {
            var tmp = new ArrayList<Integer>(size);
            for (int i = 0; i < nums.length; i++) {
                tmp.add(nums[i]);
            }
            out.add(tmp);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            generate(out, nums, pos + 1, size);
            swap(nums, pos, i);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        if (nums.length == 1) return List.of(List.of(nums[0]));
        List<List<Integer>> out = new ArrayList<>();
        generate(out, nums, 0, nums.length);
        return out;
    }

    public static void main(String[] args) {
        var solution = new Permutations46();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
    
}
