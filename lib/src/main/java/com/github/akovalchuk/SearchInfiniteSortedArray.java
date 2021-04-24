package com.github.akovalchuk;

/**
 * Educative.io. Search in a Sorted Infinite Array (medium)
 */
public class SearchInfiniteSortedArray {
    
    public static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public static int search(ArrayReader reader, int key) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int val = reader.get(mi);
            if (val == Integer.MAX_VALUE || key < val) {
                hi = mi - 1;
            } else if (key > val) {
                lo = mi + 1;
            } else {
                return val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}
