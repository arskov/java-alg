package com.github.akovalchuk;

/**
 * Educative.io. Minimum Deletions in a String to make it a Palindrome
 * <p>
 * Given a string, find the minimum number of characters that we can remove to
 * make it a palindrome.
 */
public class MinimumDeletionsMakePalindrome {

    public static int findMinimumDeletions(String st) {
        if (st == null || st.isEmpty())
            return 0;
        Integer[][] memo = new Integer[st.length()][st.length()];
        return dfs(st, 0, st.length() - 1, memo);
    }

    private static int dfs(String st, int s, int e, Integer[][] memo) {
        if (s >= e) 
            return 0;
        if (memo[s][e] != null)
            return memo[s][e];
        if (st.charAt(s) == st.charAt(e)) {
            int r = dfs(st, s + 1, e - 1, memo);
            memo[s][e] = r;
        } else {
            int a = dfs(st, s + 1, e, memo);
            int b = dfs(st, s, e - 1, memo);
            memo[s][e] = Math.min(a, b) + 1;
        }
        return memo[s][e];
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDeletions("abdbca"));
        System.out.println(findMinimumDeletions("cddpd"));
        System.out.println(findMinimumDeletions("pqr"));
    }
}
