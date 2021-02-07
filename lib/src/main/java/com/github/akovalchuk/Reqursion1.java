package com.github.akovalchuk;

import java.util.Arrays;

/** 
 * Given am array of ints, return the array where each element contains the sum of the previous elements.
 */
public class Reqursion1 {

    int[] reqSum(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        int res = helper(arr, arr.length - 1);
        arr[arr.length - 1] = res;
        return arr;
    }

    int helper(int[] arr, int idx) {
        if (idx == 0) return arr[0];
        int res = arr[idx] + helper(arr, idx - 1);
        arr[idx] = res;
        return res;
    }

    public static void main(String[] args) {
        var r = new Reqursion1();
        System.out.println(Arrays.toString(r.reqSum(new int[] {1,2,3,4,5,6})));
    }
    
}
