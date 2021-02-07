package com.github.akovalchuk;

import java.util.HashMap;

public class MinLengthSubstring {

    int minLengthSubstring(String s, String t) {
        // Write your code here
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return 0;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer counter = dic.getOrDefault(t.charAt(i), 0);
            counter++;
            dic.put(t.charAt(i), counter);
        }
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int curLen = t.length();
        while (l < s.length() && r < s.length()) {
            char c = s.charAt(r);
            if (dic.containsKey(c)) {
                Integer counter = dic.get(c);
                if (counter > 0 && curLen > 0) {
                    dic.compute(c, (k, v) -> v - 1);
                    curLen--;
                }
                if (curLen == 0) {
                    min = Math.min(min, r - l + 1);
                    char d = s.charAt(l);
                    if (dic.containsKey(d)) {
                        dic.compute(d, (k, v) -> v + 1);
                        curLen++;
                    }
                    l++;
                    continue;
                }
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        var sol = new MinLengthSubstring();
        System.out.println(sol.minLengthSubstring("dcbefebce", "fd"));
        System.out.println(sol.minLengthSubstring("dcbefdebce", "fd"));
    }
}
