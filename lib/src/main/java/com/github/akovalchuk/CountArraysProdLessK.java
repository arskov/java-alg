package com.github.akovalchuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 713. Subarray Product Less Than K
 */
public class CountArraysProdLessK {

    public int numSubarrayProductLessThanK_LogN(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        double[] prefSum = new double[nums.length + 1];
        double logk = Math.log(k);
        for (int i = 0; i < nums.length; i++) {
            prefSum[i + 1] = prefSum[i] + Math.log(nums[i]);
        }
        for (int i = 0; i < prefSum.length; i++) {
            int r = Arrays.binarySearch(prefSum, i + 1, prefSum.length, prefSum[i] + logk - 1e-9);
            // (-(insertion point) - 1)  = r,  -i-1=r, i+1=-r 
            if (r >= 0) {
                count += r - i - 1;
            } else {
                count += (-r-1) - i - 1;
            }
            
        }
        
        return count;
    }
    
    public int numSubarrayProductLessThanK_N(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0;
        int count = 0;
        int l = 0;
        int r = 0;
        int prod = 1;
        while (r < nums.length) {
            prod = prod * nums[r];
            while (prod >= k && l <= r) prod = prod / nums[l++];
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        var s = new CountArraysProdLessK();
        int[] test = null;
        int target = 0;
        try (var is = new BufferedReader(new InputStreamReader(CountArraysProdLessK.class.getClassLoader().getResourceAsStream("count_arrays_prod_less_then_k.txt")))) {
            var arrStr = is.readLine();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            var arr = new ArrayList<Integer>();
            try (var scanner = new Scanner(arrStr)) {
                scanner.useDelimiter(",");
                while (scanner.hasNextInt()) {
                    arr.add(scanner.nextInt());
                }
            }
            test = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) test[i] = arr.get(i);
            target = Integer.parseInt(is.readLine());
        }
        System.out.println(s.numSubarrayProductLessThanK_LogN(test, target));
        System.out.println(s.numSubarrayProductLessThanK_N(test, target));
    }
}
