package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string cut the string into palincromic substrings
 */
public class CutStringToPalindromes {

    public static List<String> cutString(String st) {
        if (st == null || st.isEmpty())
            return Collections.emptyList();
        var memo = new Boolean[st.length()][st.length()];
        var result = new HashSet<String>();
        dfs(st, 0, st.length() - 1, memo, result);
        return new ArrayList<>(result);
    }
    
    private static boolean dfs(String st, int i, int j, Boolean[][] memo, HashSet<String> result) {
        if (i >= j) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res = dfs(st, i + 1, j - 1, memo, result);
        if (res && st.charAt(i) == st.charAt(j)) {
            result.add(st.substring(i, j + 1));
        }
        res = dfs(st, i + 1, j, memo, result);
        if (res) {
            result.add(st.substring(i + 1, j + 1));
        }
        res = dfs(st, i, j - 1, memo, result);
        if (res) {
            result.add(st.substring(i, j));
        }
        memo[i][j] = res && st.charAt(i) == st.charAt(j);
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(cutString("abdbca"));
        System.out.println(cutString("cddpd"));
        System.out.println(cutString("pqr"));
    }
}
