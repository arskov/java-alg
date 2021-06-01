package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode. 140. Word Break II
 */
public class WordBreak1 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        var dic = new LinkedHashSet<String>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
        return helper(s, 0, dic, dp);
    }

    private Boolean helper(String s, int pos, Set<String> dic, Boolean[] dp) {
        if (dp[pos] != null) return dp[pos];
        if (pos == s.length()) return Boolean.TRUE;
        for (var w : dic) {
            int idx = s.indexOf(w, pos);
            if (idx == pos) {
                Boolean result = helper(s, pos + w.length(), dic, dp);
                if (result) {
                    dp[pos] = Boolean.TRUE;
                    return dp[pos];
                }
            }
        }
        dp[pos] = Boolean.FALSE;
        return dp[pos];
    }
    
    public static void main(String[] args) {
        var sol = new WordBreak1();
        var dic = new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dic));
    }
}
