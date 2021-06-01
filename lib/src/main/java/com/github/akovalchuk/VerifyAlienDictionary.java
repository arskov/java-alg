package com.github.akovalchuk;

/**
 * Leetcode. 953. Verifying an Alien Dictionary
 */
public class VerifyAlienDictionary {
    
    public boolean isAlienSorted(String[] words, String order) {
        if (order == null || order.length() == 0 || words == null || words.length == 0) return false;
        int[] dic = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dic[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], dic) > 0) return false;
        }
        return true;
    }
    
    private int compare(String word1, String word2, int[] dic) {
        int minSize = Math.min(word1.length(), word2.length());
        for (int i = 0; i < minSize; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (dic[word1.charAt(i) - 'a'] < dic[word2.charAt(i) - 'a']) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        if (word1.length() == word2.length()) return 0;
        else if (word1.length() > word2.length()) return 1;
        else return -1;
    }

    public static void main(String[] args) {
        var sol = new VerifyAlienDictionary();
        String[] words = { "hello" , "leetcode" };
        var order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(sol.isAlienSorted(words, order));
    }

}
