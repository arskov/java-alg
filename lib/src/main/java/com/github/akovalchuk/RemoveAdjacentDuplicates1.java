package com.github.akovalchuk;

/**
 * Leetcode. 1209. Remove All Adjacent Duplicates in String II
 */
public class RemoveAdjacentDuplicates1 {

    public static String removeDuplicates(String s, int k) {
        boolean found = true;
        var sb = new StringBuilder();
        int[] dict = new int[26];
        while (found) {
            int l = 0;
            int r = 0;
            found = false;
            while (l < s.length()) {
                if (r < s.length()) {
                    char rc = s.charAt(r);
                    dict[rc - 'a']++;
                }
                if (r - l + 1 > k || r == s.length()) {
                    char lc = s.charAt(l);
                    dict[lc - 'a']--;
                    sb.append(lc);
                    l++;
                }
                if (r < s.length() && r - l + 1 == k && count(dict) == 1) {
                    found = true;
                    char lc = s.charAt(l);
                    dict[lc - 'a'] = 0;
                    l = r;
                    l += 1;
                }
                if (r < s.length()) r++;
            }
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
    
    private static int count(int[] dict) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (dict[i] > 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
