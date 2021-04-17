package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Educative.io. String Permutations by changing case (medium)
 * 
 * Leetcode. 784. Letter Case Permutation
 */
public class LetterCasePermutation1 {

    public static List<String> letterCasePermutation(String str) {
        if (str == null || str.length() == 0)
            return Collections.emptyList();
        var buf = new StringBuilder(str.toLowerCase());
        var set = new HashSet<String>();
        gen(buf, 0, set);
        return new ArrayList<>(set);
    }

    private static void gen(StringBuilder buf, int s, Set<String> vis) {
        if (vis.contains(buf.toString()))
            return;
        if (s == buf.length()) {
            vis.add(buf.toString());
            return;
        }
        for (int i = s; i < buf.length(); i++) {
            gen(buf, i + 1, vis);
            char c = buf.charAt(i);
            if (Character.isAlphabetic(c)) {
                buf.setCharAt(i, Character.toUpperCase(c));
                gen(buf, i + 1, vis);
                buf.setCharAt(i, Character.toLowerCase(c));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("ab7c"));
    }

}
