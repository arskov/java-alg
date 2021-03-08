package com.github.akovalchuk;

/**
 * 896. Monotonic Array
 */
public class MonotonicArray {
    
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) return false;
        Boolean inc = null;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (inc == null) inc = true;
                if (!inc) return false;
            } else if (A[i - 1] > A[i]) {
                if (inc == null) inc = false;
                if (inc) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var s = new MonotonicArray();
        int[] test1 = {1,2,3,4,5,6};
        int[] test2 = {1,2,3,4,2,5};
        int[] test3 = {5,4,3,2,2,1};
        int[] test4 = {2,2,2,2,2,2};
        System.out.println(s.isMonotonic(test1));
        System.out.println(s.isMonotonic(test2));
        System.out.println(s.isMonotonic(test3));
        System.out.println(s.isMonotonic(test4));
    }


}
