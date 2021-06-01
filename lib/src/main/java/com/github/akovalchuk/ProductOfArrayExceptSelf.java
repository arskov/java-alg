package com.github.akovalchuk;

import java.util.Arrays;

/**
 * Leetcode. 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {
    /*
    3,4,5,4,2
    
    3   12   60  240 480
    480 160  40  8   2
    
    ======
    160 120  96  120 240
    */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] out = new int[nums.length];
        int[] prodRev = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            prodRev[i] = (i == nums.length - 1 ? nums[i] : prodRev[i + 1] * nums[i]); 
        }
        int prodFv = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] = prodFv * (i == nums.length - 1 ? 1 : prodRev[i + 1]);
            prodFv *= nums[i];
        }
        return out;
    }

    public static void main(String[] args) {
        var sol = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[] {3,4,5,4,2})));
    }
}
