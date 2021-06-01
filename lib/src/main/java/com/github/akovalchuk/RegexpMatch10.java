package com.github.akovalchuk;

/**
 * Leetcode. 10. Regular Expression Matching
 */
public class RegexpMatch10 {

    Boolean[][] memo;

    public boolean isMatchRecursion(String s, String p) {
        if (p == null || s == null)
            return false;
        if (p.isEmpty())
            return s.isEmpty();
        boolean first = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatchRecursion(s, p.substring(2)) || (first && isMatchRecursion(s.substring(1), p));
        } else {
            return first && isMatchRecursion(s.substring(1), p.substring(1));
        }
    }

    private Boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null)
            return memo[i][j];
        Boolean result;
        if (j == p.length()) {
            result = (i == s.length());
        } else {
            Boolean first = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = dp(i, j + 2, s, p) || (first && dp(i + 1, j, s, p));
            } else {
                result = first && dp(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = result;
        return result;
    }
    
    public boolean isMatchRecursionMemo(String s, String p) {
        if (p == null || s == null)
            return false;
        if (p.isEmpty())
            return s.isEmpty();
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public static void main(String[] args) {
        var solution = new RegexpMatch10();
        System.out.println(solution.isMatchRecursion("sss", "ppp"));
        System.out.println(solution.isMatchRecursionMemo("sss", "ppp"));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", "s"));
        System.out.println(solution.isMatchRecursionMemo("sss", "s"));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", "s*"));
        System.out.println(solution.isMatchRecursionMemo("sss", "s*"));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", ".*"));
        System.out.println(solution.isMatchRecursionMemo("sss", ".*"));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", "."));
        System.out.println(solution.isMatchRecursionMemo("sss", "."));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", ".."));
        System.out.println(solution.isMatchRecursionMemo("sss", ".."));
        System.out.println();
        System.out.println(solution.isMatchRecursion("sss", "..."));
        System.out.println(solution.isMatchRecursionMemo("sss", "..."));
    }
}
