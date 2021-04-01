package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * Educative.io. Words Concatenation (hard)
 * 
 * Input: s = "lingmindraboofooowingdingbarrwingmonkeypoundcake", words =
 * ["fooo","barr","wing","ding","wing"] Output: [13]
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"] Output:
 * [6,9,12]
 * 
 */
public class FindSubstringWithConcatenationOfWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words == null || words.length == 0)
            return Collections.emptyList();
        var result = new ArrayList<Integer>();
        int wordLen = words[0].length();
        int totalLen = words[0].length() * words.length;
        int wordCount = words.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (var entry : map.entrySet()) {
            var w = entry.getKey();
            int lastIdx = 0;
            while (true) {
                // TODO : it's the main bottleneck
                int pos = s.indexOf(w, lastIdx);
                if (pos != -1 && pos + totalLen <= s.length()) {
                    boolean res = find(s, pos, wordLen, wordCount, result, map);
                    lastIdx = pos + 1;
                    // if (res) {
                    // lastIdx = pos + wordLen;
                    // } else {
                    // lastIdx = pos + 1;
                    // }
                } else {
                    break;
                }
            }
        }
        result.sort(null);
        return result;
    }

    private static boolean find(String s, int start, int wordLen, int wordCount, List<Integer> result,
            Map<String, Integer> map) {

        Map<String, Integer> dict = new HashMap<>();
        dict.putAll(map);

        List<String> macroWord = new ArrayList<>();
        for (int i = start; i <= s.length() - wordLen; i += wordLen) {
            macroWord.add(s.substring(i, i + wordLen));
        }

        int matched = 0;
        for (int r = 0; r < wordCount; r++) {
            String subWord = macroWord.get(r);
            if (dict.containsKey(subWord)) {
                dict.put(subWord, dict.get(subWord) - 1);
                if (dict.get(subWord) == 0)
                    matched++;
            } else {
                return false;
            }
            if (matched == dict.size()) {
                result.add(start);
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(
            findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
        System.out.println(
            findWordConcatenation("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
        
        System.out.println(
            findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] { "fooo", "barr", "wing", "ding", "wing" }));
        System.out.println(
            findWordConcatenation("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] { "fooo", "barr", "wing", "ding", "wing" }));
        
        System.out.println(findSubstring("aaaaaaaaaaaaaa", new String[] { "aa", "aa" }));
        System.out.println(findWordConcatenation("aaaaaaaaaaaaaa", new String[] { "aa", "aa" }));
    }
}
