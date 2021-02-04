package com.github.akovalchuk;

public class LexicographicalOrder {
    // Add any helper functions you may need here
    // O(N)
    // O(N)
    int[] findMinIndex(int[] arr, int k) {
        int minIdx = -1;
        int excludes = 0;
        int remainingK = k;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                excludes++;
                continue;
            }
            if (minIdx == -1)
                minIdx = i;
            String a = String.valueOf(arr[i]);
            String b = String.valueOf(arr[minIdx]);
            if (a.length() < b.length() || (a.length() == b.length() && a.compareTo(b) < 0)) {
                minIdx = i;
            }
            remainingK = k - minIdx - excludes;
            if (remainingK == 0)
                break;
        }
        return new int[] { minIdx, remainingK };
    }

    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        // O(K*N) in case of already sorted, O(N) - space
        if (arr == null || arr.length == 0 || k == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        int r = 0;
        while (k > 0) {
            // find min
            int[] result = findMinIndex(arr, k);
            // put min as the first
            res[r++] = arr[result[0]];
            // calculate new k, the new k is k minus number of swaps
            k = result[1];
            arr[result[0]] = -1;
            // repeat
        }
        // complete the array
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != -1) {
                res[r++] = arr[j];
            }
        }
        // return
        return res;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = { 5, 3, 1 };
        int[] expected_1 = { 1, 5, 3 };
        int[] output_1 = findMinArray(arr_1, k_1);
        check(expected_1, output_1);

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = { 8, 9, 11, 2, 1 };
        int[] expected_2 = { 2, 8, 9, 11, 1 };
        int[] output_2 = findMinArray(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new LexicographicalOrder().run();
    }

}
