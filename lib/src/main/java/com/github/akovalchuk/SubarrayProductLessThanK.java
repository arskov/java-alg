package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Educative.io. Subarrays with Product Less than a Target (medium)
 */
public class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int l = 0;
        int p = 1;
        for (int r = 0; r < arr.length; r++) {
            p *= arr[r];
            while (p >= target)
                p /= arr[l++];
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = r; i >= l; i--) {
                tmp.addFirst(arr[i]);
                subarrays.add(new ArrayList<>(tmp));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5000));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }

}
