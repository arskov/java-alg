package com.github.akovalchuk;

/**
 * Educative.io. Shortest Common Super-sequence
 * 
 * Given two sequences ‘s1’ and ‘s2’, write a method to find the length of the
 * shortest sequence which has ‘s1’ and ‘s2’ as subsequences.
 */
public class ShortestCommonSuperSequence {

    public static int findSCSLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return 0;
        Integer[][] memo = new Integer[s1.length()][s2.length()];
        return find(s1, s2, 0, 0, memo);
    }

    private static int find(String s1, String s2, int i1, int i2, Integer[][] memo) {
        if (i1 == s1.length())
            return s2.length() - i2;
        if (i2 == s2.length())
            return s1.length() - i1;
        if (memo[i1][i2] != null) {
            return memo[i1][i2];
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            a = 1 + find(s1, s2, i1 + 1, i2 + 1, memo);
        } else {
            b = 1 + find(s1, s2, i1 + 1, i2, memo);
            c = 1 + find(s1, s2, i1, i2 + 1, memo);
        }
        memo[i1][i2] = Math.min(a, Math.min(b, c));
        return memo[i1][i2];
    }

    public static void main(String[] args) {
        System.out.println(findSCSLength("abcf", "bdcf"));
        System.out.println(findSCSLength("dynamic", "programming"));
    }
}
