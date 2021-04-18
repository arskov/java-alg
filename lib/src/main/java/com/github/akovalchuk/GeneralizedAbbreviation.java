package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Educative.io. Unique Generalized Abbreviations (hard)
 * 
 * Leetcode. 320. Generalized Abbreviation
 */
public class GeneralizedAbbreviation {

    private static class Word {
        StringBuilder sb;
        int pos;
        int count;

        Word(StringBuilder sb, int pos, int count) {
            this.sb = sb;
            this.pos = pos;
            this.count = count;
        }

        Word(Word word) {
            this.sb = new StringBuilder(word.sb);
            this.pos = word.pos;
            this.count = word.count;
        }
    }

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        Queue<Word> queue = new ArrayDeque<>();
        queue.offer(new Word(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Word tmp = queue.poll();
                if (tmp.pos == word.length()) {
                    if (tmp.count != 0) {
                        tmp.sb.append(tmp.count);
                    }
                    result.add(tmp.sb.toString());
                    continue;
                }
                queue.offer(new Word(new StringBuilder(tmp.sb), tmp.pos + 1, tmp.count + 1));
                if (tmp.count != 0) {
                    tmp.sb.append(tmp.count);
                }
                queue.offer(new Word(new StringBuilder(tmp.sb).append(word.charAt(tmp.pos)), tmp.pos + 1, 0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = null;
        // result = generateGeneralizedAbbreviation("BAT");
        // System.out.println(result);

        // result = generateGeneralizedAbbreviation("code");
        // System.out.println(result);

        // result = generateGeneralizedAbbreviation("interaction");
        // System.out.println(result);

        result = generateGeneralizedAbbreviation("segmentation");
        System.out.println(result);
    }
}
