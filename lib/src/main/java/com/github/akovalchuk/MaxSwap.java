package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Leetcode. 670. Maximum Swap
 */
public class MaxSwap {

    public int maximumSwap(int num) {
        var nums = new ArrayList<Integer>();
        int[] idxs = new int[10];
        Arrays.fill(idxs, -1);
        int tmp = num;
        while (tmp > 0) {
            int i = tmp % 10;
            nums.add(i);
            tmp /= 10;
        }
        Collections.reverse(nums);
        for (int i = 0; i < nums.size(); i++)
            idxs[nums.get(i)] = i;
        outer: for (int i = 0; i < nums.size(); i++) {
            for (int j = 9; j > nums.get(i); j--) {
                if (idxs[j] > i) {
                    Collections.swap(nums, i, idxs[j]);
                    break outer;
                }
            }
        }
        int res = 0;
        for (var n : nums) {
            res *= 10;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new MaxSwap();
        System.out.println(s.maximumSwap(21));
        System.out.println(s.maximumSwap(12));
        System.out.println(s.maximumSwap(212));
        System.out.println(s.maximumSwap(2124));
        System.out.println(s.maximumSwap(321));
    }
}
