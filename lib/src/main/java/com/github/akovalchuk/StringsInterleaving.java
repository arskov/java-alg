package com.github.akovalchuk;

/**
 * Educative.io. Strings Interleaving
 * 
 * Give three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has
 * been formed by interleaving ‘m’ and ‘n’. ‘p’ would be considered interleaving
 * ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order of
 * letters is preserved too.
 */
public class StringsInterleaving {

    public static boolean findSI(String m, String n, String p) {
        if (m == null || n == null || p == null || m.length() + n.length() != p.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[m.length()][n.length()];
        return find(m, n, 0, 0, p, memo);
    }

    private static boolean find(String m, String n, int i, int j, String p, Boolean[][] memo) {
        if (i == m.length()) {
            return n.substring(j).equals(p.substring(i + j));
        }
        if (j == n.length()) {
            return m.substring(i).equals(p.substring(i + j));
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (m.charAt(i) == p.charAt(i + j)) {
            memo[i][j] = find(m, n, i + 1, j, p, memo);
        } else if (n.charAt(j) == p.charAt(i + j)) {
            memo[i][j] = find(m, n, i, j + 1, p, memo);
        } else {
            memo[i][j] = false;
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(findSI("abc", "def", "adbecf"));
        System.out.println(findSI("abd", "cef", "abcdef"));
        System.out.println(findSI("abd", "cef", "adcbef"));
        System.out.println(findSI("abc", "def", "abdccf"));
        System.out.println(findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
