package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations47 {
    
    private void generate(List<List<Integer>> out, ArrayList<Integer> rest, ArrayList<Integer> pattern) {
        if (rest.isEmpty()) {
            out.add(new ArrayList<>(pattern));
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            if ( i == 0 || !rest.get(i).equals(rest.get(i - 1)) ) {
                var newRest = new ArrayList<>(rest);
                Integer num = newRest.remove(i);
                pattern.add(num);
                generate(out, newRest, pattern);
                // don't forget to backtrack, because we use the same instances of collections
                pattern.remove(pattern.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        if (nums.length == 1)
            return List.of(List.of(nums[0]));
        Arrays.sort(nums);
        var rest = new ArrayList<Integer>();
        for (int n : nums) {
            rest.add(n);
        }
        var pattern = new ArrayList<Integer>();
        var out = new ArrayList<List<Integer>>();
        generate(out, rest, pattern);
        return out;
    }

    public static void main(String[] args) {
        var solution = new Permutations47();
        System.out.println(solution.permuteUnique(new int[] {1,1,2}));
        System.out.println(solution.permuteUnique(new int[] {1,2,3}));
    }
}
