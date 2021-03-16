package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 68. Text Justification
 */
public class TextJustification {
    
    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth == 0) return Collections.emptyList();
        var result = new ArrayList<String>();
        var tmpList = new ArrayList<String>();
        int lineLength = 0;
        int wordsLength = 0;
        int i = 0;
        while (i < words.length) {
            var word = words[i];
            if (lineLength == 0 || (lineLength + 1 + word.length()) <= maxWidth) {
                // add word to the line
                tmpList.add(word);
                lineLength += lineLength == 0 ? word.length() : 1 + word.length();
                wordsLength += word.length();
                i++;
            } else {
                // justify and add to the result
                int totalSpaces = maxWidth - wordsLength; // 8
                int totalGaps = tmpList.size() - 1; // 2
                int minGap = totalGaps == 0 ? totalSpaces : totalSpaces / totalGaps; // 4
                var spacer = new StringBuilder(minGap);
                for (int j = 0; j < minGap; j++) spacer.append(' ');
                int remSpaces = totalGaps == 0 ? 0 : totalSpaces % totalGaps; // 8 % 2
                var sb = new StringBuilder();
                int tmpStrLen = 0;
                for (int j = 0; j < tmpList.size(); j++) {
                    sb.append(tmpList.get(j));
                    tmpStrLen += tmpList.get(j).length();
                    if (tmpStrLen + minGap <= maxWidth) {
                        tmpStrLen += minGap;
                        sb.append(spacer);
                    }
                    if (remSpaces > 0) {
                        if (tmpStrLen + 1 <= maxWidth) {
                            tmpStrLen += 1;
                            sb.append(' ');
                            remSpaces--;
                        }
                    }
                }
                lineLength = 0;
                wordsLength = 0;
                tmpList.clear();
                result.add(sb.toString());
            }
        }
        var sb = new StringBuilder();
        var it = tmpList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(' ');
        }
        int rem = maxWidth - sb.length();
        for (i = 0; i < rem; i++) sb.append(' ');
        result.add(sb.toString());
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        var result = fullJustify(words, 16);
        for (var line : result) {
            System.out.println(line);
        }
    }
}
