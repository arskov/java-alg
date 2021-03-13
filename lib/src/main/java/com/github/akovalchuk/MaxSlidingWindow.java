package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *  Find Maximum in Sliding Window
 */
public class MaxSlidingWindow {

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<Integer> windowMax = new ArrayDeque<>();
        windowMax.add(0);
        for (int i = 1; i < windowSize; i++) {
            while (!windowMax.isEmpty() && arr[i] > arr[windowMax.peekLast()])
                windowMax.pollLast();
            windowMax.addLast(i);
        }
        result.add(arr[windowMax.peekFirst()]);
        for (int i = 0; i < arr.length - windowSize; i++) {
            int add = arr[i + windowSize];
            while (!windowMax.isEmpty() && add > arr[windowMax.peekLast()])
                windowMax.pollLast();
            windowMax.addLast(i + windowSize);
            while (!windowMax.isEmpty() && windowMax.peekFirst() <= i)
                windowMax.pollFirst();
            result.add(arr[windowMax.peekFirst()]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = { -4, 2, -5, 1, -1, 6 };
        System.out.println("Array = " + Arrays.toString(array1));
        System.out.println("Max = " + findMaxSlidingWindow(array1, 3));

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Array = " + Arrays.toString(array));
        System.out.println("Max = " + findMaxSlidingWindow(array, 3));

        int[] array2 = { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 };
        System.out.println("Array = " + Arrays.toString(array2));
        System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
    }

}
