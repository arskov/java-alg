package com.github.akovalchuk;

public class PermutationsFB {

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
          i++;
          j--;
        }
    }
    
    int minOperations(int[] arr) {
        // Write your code here
        if (arr == null || arr.length <= 1)
          return 0;
        int counter = 0;
        
        while (true) {
          int minIdx = -1;
          int maxIdx = -1;
          for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
              if (minIdx == -1) {
                minIdx = i;
              }
              maxIdx = i;
            }
          }
          if (minIdx == -1) {
            break;
          }
          reverse(arr, minIdx, maxIdx);
          counter++;
        }
        return counter;
    }
  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {

    int n_1 = 5;
    int[] arr_1 = {1, 2, 5, 4, 3};
    int expected_1 = 1;
    int output_1 = minOperations(arr_1);
    check(expected_1, output_1);

    int n_2 = 3;
    int[] arr_2 = {3, 1, 2};
    int expected_2 = 2;
    int output_2 = minOperations(arr_2);
    check(expected_2, output_2);
    
    // Add your own test cases here
    int n_3 = 5;
    int[] arr_3 = {5, 3, 2, 4, 1}; 
    int expected_3 = 3;
    int output_3 = minOperations(arr_3);
    check(expected_3, output_3);
    
  }

  public static void main(String[] args) {
    new PermutationsFB().run();
  }
}
