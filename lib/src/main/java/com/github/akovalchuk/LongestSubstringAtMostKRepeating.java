package com.github.akovalchuk;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringAtMostKRepeating {
    /*
    baacaccra k=2
    
    baac
     aac
     aaca
     aacacc
     aacaccr
      acaccr
       caccr
        accr
         ccra
          cra
           ra
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) return 0;
        int[] dict = new int[256];
        int countDistinct = 0;
        int l = 0;
        int r = 0;
        int max = 1;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (dict[c] == 0) countDistinct++;
            dict[c]++;
            while (countDistinct > k) {
                char d = s.charAt(l);
                dict[d]--;
                if (dict[d] == 0) countDistinct--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new LongestSubstringAtMostKRepeating();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(sol.lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(sol.lengthOfLongestSubstringKDistinct("ababffzzeee", 2));
    }
}
