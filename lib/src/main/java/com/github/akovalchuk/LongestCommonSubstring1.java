package com.github.akovalchuk;

/**
 * Educative.io. Longest Common Substring
 * <p>
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring
 * which is common in both the strings.
 */
public class LongestCommonSubstring1 {

    public static int findLCSLength(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
            return 0;
        int maxLength = Math.min(s1.length(), s2.length());
        Integer[][][] memo = new Integer[s1.length()][s2.length()][maxLength];
        return find(s1, s2, 0, 0, 0, memo);
    }

    private static int find(String s1, String s2, int i1, int i2, int count, Integer[][][] memo) {
        if (i1 == s1.length() || i2 == s2.length())
            return count;
        if (memo[i1][i2][count] != null) {
            return memo[i1][i2][count];
        }
        int c = count;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            c = find(s1, s2, i1 + 1, i2 + 1, count + 1, memo);
        }
        int a = find(s1, s2, i1 + 1, i2, 0, memo);
        int b = find(s1, s2, i1, i2 + 1, 0, memo);
        memo[i1][i2][count] = Math.max(c, Math.max(a, b));
        return memo[i1][i2][count];
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
