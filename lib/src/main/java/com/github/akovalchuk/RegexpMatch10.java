package com.github.akovalchuk;

/**
 * 10. Regular Expression Matching
 */
public class RegexpMatch10 {

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

    public static void main(String[] args) {
        var solution = new RegexpMatch10();
        System.out.println(solution.isMatchRecursion("sss", "ppp"));
        System.out.println(solution.isMatchRecursion("sss", "s"));
        System.out.println(solution.isMatchRecursion("sss", "s*"));
        System.out.println(solution.isMatchRecursion("sss", ".*"));
        System.out.println(solution.isMatchRecursion("sss", "."));
        System.out.println(solution.isMatchRecursion("sss", ".."));
        System.out.println(solution.isMatchRecursion("sss", "..."));
    }
}
