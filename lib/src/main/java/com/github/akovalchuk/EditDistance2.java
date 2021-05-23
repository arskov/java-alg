package com.github.akovalchuk;

/**
 * Educative.io. Edit Distance
 * 
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting,
 * inserting, or replacing characters. Write a function to calculate the count
 * of the minimum number of edit operations.
 */
public class EditDistance2 {
    
    public static int findMinOperations(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return -1;
        Integer[][] memo = new Integer[s1.length()][s2.length()];
        return dist(s1, s2, 0, 0, memo);
    }

    private static int dist(String s1, String s2, int i1, int i2, Integer[][] memo) {
        if (i1 == s1.length()) return s2.length() - i2;
        if (i2 == s2.length()) return s1.length() - i1;
        if (memo[i1][i2] != null) return memo[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) {
            memo[i1][i2] = dist(s1, s2, i1 + 1, i2 + 1, memo);
        } else {
            int a = 1 + dist(s1, s2, i1 + 1, i2 + 1, memo);
            int b = 1 + dist(s1, s2, i1 + 1, i2, memo);
            int c = 1 + dist(s1, s2, i1, i2 + 1, memo);
            memo[i1][i2] = Math.min(a, Math.min(b, c));
        }
        return memo[i1][i2];
    }

    public static void main(String[] args) {
        System.out.println(findMinOperations("bat", "but"));
        System.out.println(findMinOperations("abdca", "cbda"));
        System.out.println(findMinOperations("passpot", "ppsspqrt"));
    }
}
