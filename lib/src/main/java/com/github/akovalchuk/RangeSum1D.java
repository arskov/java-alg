package com.github.akovalchuk;

public class RangeSum1D {

    private int[] prefSum;
    private int[] input;

    public RangeSum1D(int[] input) {
        if (input == null) throw new RuntimeException("array must not be null");
        this.input = input;
        prefSum = new int[input.length + 1];
        prefSum[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            prefSum[i] = prefSum[i - 1] + input[i];
        }
    }

    public int findSum(int s, int e) {
        if (s < 0 || e < 0 || s >= input.length || e > input.length || s > e) return 0;
        return prefSum[e] - (s == 0 ? 0 : prefSum[s - 1]);
    }
    
    public static void main(String[] args) {
        var sol = new RangeSum1D(new int[] {1,2,4,2,5,8,9,6,3,1,5,6});
        System.out.println(sol.findSum(2,6));
        System.out.println(sol.findSum(0,3));
    }

}
