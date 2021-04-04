package com.github.akovalchuk;
  
/**
 * Educative.io. Cycle in a Circular Array (hard):
 * 
 * We are given an array containing positive and negative numbers. 
 * Suppose the array contains a number ‘M’ at a particular index. 
 * Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. 
 * You should assume that the array is circular which means two things:
 *  - If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 *  - If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 * Write a method to determine if the array has a cycle.
 * The cycle should have more than one element and should follow one direction which means the cycle
 * should not contain both forward and backward movements.
 * 
 * 457. Circular Array Loop
 * 
 */
public class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        if (arr == null || arr.length == 1) return false;
        for (int i = 0; i < arr.length; i++) {
            boolean res = findCycle(arr, i, arr[i] >= 0);
            if (res) return true;
        }
        return false;
    }

    private static boolean findCycle(int[] arr, int start, boolean isPositive) {
        int slow = start;
        int fast = start;
        while (slow != -1 && fast != -1) {
            slow = getNext(slow, arr, isPositive);
            fast = getNext(getNext(fast, arr, isPositive), arr, isPositive);
            if (slow != -1 && fast != -1 && slow == fast) return true;
        }
        return false;
    }

    private static int getNext(int i, int[] arr, boolean isPositive) {
        if (i == -1) return -1;
        int next = -1;
        if ((isPositive && arr[i] < 0) || (!isPositive && arr[i] > 0)) return -1;
        if (isPositive) {
            next = (i + arr[i]) % arr.length;
        } else {
            next = i + arr[i];
            if (next < 0) {
                next %= arr.length;
                next = arr.length + next;
            }
        }
        if (next == i) return -1;
        return next;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }) == true);
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }) == true);
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }) == false);
        System.out.println(CircularArrayLoop.loopExists(new int[] { -1, 2 }) == false);
        System.out.println(CircularArrayLoop.loopExists(new int[] { -1 }) == false);
    }

}
