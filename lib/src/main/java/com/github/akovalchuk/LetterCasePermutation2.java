package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Educative.io. String Permutations by changing case (medium)
 * 
 * Leetcode. 784. Letter Case Permutation
 */
public class LetterCasePermutation2 {

    public static List<String> findLetterCaseStringPermutations(String str) {
        if (str == null || str.length() == 0)
            return Collections.emptyList();
        String start = str.toLowerCase();
        ArrayDeque<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder());
        for (int i = 0; i < str.length(); i++) {
            int len = queue.size();
            char c = start.charAt(i);
            for (int j = 0; j < len; j++) {
                StringBuilder tmp1 = queue.poll();
                StringBuilder tmp2 = new StringBuilder(tmp1);
                tmp1.append(c);
                queue.offer(tmp1);
                if (Character.isAlphabetic(c)) {
                    tmp2.append(Character.toUpperCase(c));
                    queue.offer(tmp2);
                }
            }
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLetterCaseStringPermutations("a1b2"));
        System.out.println(findLetterCaseStringPermutations("ab7c"));
    }
}
