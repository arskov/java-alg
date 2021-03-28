package com.github.akovalchuk;

/**
 * Educative.io. Permutation in a String (hard)
 */
public class FindStringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        if (pattern == null || str == null || str.isEmpty() || pattern.isEmpty())
            return false;
        int patLen = pattern.length();
        int[] patDict = new int[26];
        for (int i = 0; i < pattern.length(); i++)
            patDict[pattern.charAt(i) - 'a']++;
        int[] winDict = new int[26];
        for (int i = 0; i < pattern.length(); i++)
            winDict[str.charAt(i) - 'a']++;
        for (int i = patLen; i < str.length(); i++) {
            if (compare(patDict, winDict))
                return true;
            winDict[str.charAt(i) - 'a']++;
            winDict[str.charAt(i - patLen) - 'a']--;
        }
        return compare(patDict, winDict);
    }

    private static boolean compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx") == true);
        System.out.println(findPermutation("aaacb", "abc") == true);
        System.out.println(findPermutation("oidbcaf", "abc") == true);
        System.out.println(findPermutation("odicf", "dc") == false);
    }
}
