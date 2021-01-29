package com.github.akovalchuk;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        var solution = new MoveZeroes();
        int[] test_1 = new int[]{1,0,2,0,3,5,0,6};
        System.out.println(Arrays.toString(test_1));
        solution.moveZeroes(test_1);
        System.out.println(Arrays.toString(test_1));
    }
    
}
