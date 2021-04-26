package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Educative.io. 'K' Closest Numbers (medium)
 * 
 * Letcode. 658. Find K Closest Elements
 * 
 * Note! If numbers are unsorded then O(NlogK + KLogK) => O(NLogN) If numbers
 * are sorted then we can use a binary sort here.
 */
public class KClosestElements {
    public static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static List<Integer> findClosestElements1(int[] arr, int K, Integer X) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Entry> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(new Entry(arr[i], Math.abs(X - arr[i])));
            if (maxHeap.size() > K)
                maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().key);
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> findClosestElements2(int[] arr, int K, Integer X) {
        List<Integer> result = new LinkedList<>();
        int index = binarySearch(arr, X);
        int leftPointer = index;
        int rightPointer = index + 1;
        for (int i = 0; i < K; i++) {
            if (leftPointer >= 0 && rightPointer < arr.length) {
                int diff1 = Math.abs(X - arr[leftPointer]);
                int diff2 = Math.abs(X - arr[rightPointer]);
                if (diff1 <= diff2)
                    result.add(0, arr[leftPointer--]); // append in the beginning
                else
                    result.add(arr[rightPointer++]); // append at the end
            } else if (leftPointer >= 0) {
                result.add(0, arr[leftPointer--]);
            } else if (rightPointer < arr.length) {
                result.add(arr[rightPointer++]);
            }
        }
        return result;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements1(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements1(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements1(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements1(new int[] { 1, 2, 3, 4, 5 }, 4, 3);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
