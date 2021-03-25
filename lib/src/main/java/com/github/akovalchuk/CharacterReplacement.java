package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;

/**
 * Educative.io. Longest Substring with Same Letters after Replacement (hard)
 */
public class CharacterReplacement {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            return 0;
        int left = 0;
        int maxRepeating = 0;
        int maxLen = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            Integer counter = countMap.compute(c, (key, val) -> val == null ? 1 : val + 1);
            maxRepeating = Math.max(maxRepeating, counter);
            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter 
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (right - left + 1 - maxRepeating > k) {
                char b = str.charAt(left);
                countMap.compute(b, (key, val) -> val == 1 ? null : val - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2) == 5);
        System.out.println(findLength("abbcb", 1) == 4);
        System.out.println(findLength("abccde", 1) == 3);
    }
}
