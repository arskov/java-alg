package com.github.akovalchuk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchingPairs {

    int matchingPairs(String s, String t) {
        // Write your code here
        if (s == null || t == null)
            return 0;
        int count = 0;
        int len = s.length();
        Map<Character, Integer> aCharMap = new HashMap<>();
        boolean repeatingFound = false;
        boolean foundBestSwap = false;
        Set<Character> notMatchingSetA = new HashSet<>();
        Set<Character> notMatchingSetB = new HashSet<>();
        Map<List<Character>, Integer> reversedNotMatchingPairs = new HashMap<>();
        // Trying O(N)
        // - if we have repeating chars in A, it means we can swap them without
        // affecting the total counter.
        // -- in case of counter == len we return the max as the total length
        // -- in case of counter < len there is a possible case when we swap chars and
        // can get more matching chars. (1 or 2)
        // --- TODO
        // - otherwise
        // -- find not matching indexes which are not in matching pairs
        // --- if there are 2 then we can increas the max by 2
        // --- if there is 1 then it doesn't increase! since another one won't match
        // --
        // c d n o m
        // c m n o d
        // find a pair with two letters with cross matching indexes
        // 1 -> pair(d, m)
        // 4 -> pair(m, d)

        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (a == b) {
                count++;
            } else {
                if (!foundBestSwap && reversedNotMatchingPairs.containsKey(Arrays.asList(a, b))) {
                    // found best swap -> +2
                    count += 2;
                    foundBestSwap = true;
                }
                notMatchingSetA.add(a);
                notMatchingSetB.add(b);
                reversedNotMatchingPairs.put(Arrays.asList(b, a), i);
            }
            Integer charCounter = aCharMap.getOrDefault(a, 0);
            if (charCounter > 0) {
                repeatingFound = true;
            }
            charCounter++;
            aCharMap.put(a, charCounter);
        }
        // if we have a pair which we can swap and get 2 new matching chars
        if (foundBestSwap) {
            return count;
        }
        // if all matches or the only one is not matched and repeating chars are found
        if (count == len || count == len - 1) {
            return repeatingFound ? count : len - 2;
        }
        // in other cases we are trying to find if we can swap something and get one
        // more matching char
        for (Character a : notMatchingSetA) {
            if (notMatchingSetB.contains(a)) {
                return count + 1;
            }
        }
        // otherwise no swaps lead to new matches
        return count;
    }

    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        String s_3 = "cdnom";
        String t_3 = "cmnod";
        int expected_3 = 5;
        int output_3 = matchingPairs(s_3, t_3);
        check(expected_3, output_3);

        String s_4 = "cdnoc";
        String t_4 = "cmnod";
        int expected_4 = 4;
        int output_4 = matchingPairs(s_4, t_4);
        check(expected_4, output_4);

        String s_5 = "cdnos";
        String t_5 = "cmnod";
        int expected_5 = 4;
        int output_5 = matchingPairs(s_5, t_5);
        check(expected_5, output_5);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }

}
