package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  140. Word Break II
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) return Collections.emptyList();
        var dict = new HashSet<String>();
        dict.addAll(wordDict);
        var result = new ArrayList<String>();
        var sb = new StringBuilder();
        var lists = dfs(s, dict);
        for (var list : lists) {
            for (var w : list) {
                sb.append(w).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        return result;
    }

    private List<List<String>> dfs(String s, Set<String> dict) {
        if (s.isEmpty()) return List.of(List.of(""));
        var result = new ArrayList<List<String>>();
        if (dict.contains(s)) {
            result.add(List.of(s));
        }
        for (int i = 1; i < s.length(); i++) {
            var left = s.substring(0, i);
            if (dict.contains(left)) {
                var subLists = dfs(s.substring(i), dict);
                for (var subList : subLists) {
                    var newSubList = new ArrayList<String>();
                    newSubList.add(left);
                    newSubList.addAll(subList);
                    result.add(newSubList);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var wb = new WordBreak2();
        String testStr1 = "pineapplepenapple";
        var dict1 = List.of("apple","pen","applepen","pine","pineapple"); 
        System.out.println(wb.wordBreak(testStr1, dict1));

        String testStr2 = "catsanddog";
        var dict2 = List.of("cat","cats","and","sand","dog");
        System.out.println(wb.wordBreak(testStr2, dict2));

        String testStr3 = "catsandog";
        var dict3 = List.of("cats","dog","sand","and","cat");
        System.out.println(wb.wordBreak(testStr3, dict3));
    }

}
