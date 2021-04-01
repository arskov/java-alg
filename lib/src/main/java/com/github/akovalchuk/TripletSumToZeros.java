package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Educative.io. Triplet Sum to Zero (medium)
 */
public class TripletSumToZeros {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int tar = arr[i];
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                if (l == i || (l > 0 && arr[l - 1] == arr[l])) {
                    l++;
                    continue;
                }
                if (r == i || (r < arr.length - 1 && arr[r] == arr[r + 1])) {
                    r--;
                    continue;
                }
                int sum = arr[l] + arr[r];
                if (-tar == sum) {
                    triplets.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    r--;
                    l++;
                } else if (sum > -tar) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
