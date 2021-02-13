package com.github.akovalchuk;

import java.util.LinkedHashMap;

public class LinkedHashMapOrder {
    public static void main(String[] args) {
        var dic1 = new LinkedHashMap<Character, Integer>();
        var dic2 = new LinkedHashMap<Character, Integer>();
        var s = "abacadc";
        for (int i = 0; i < s.length(); i++) {
            dic1.put(s.charAt(i), i);
            System.out.println(dic1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // important to remove the pair first, in order to keep the order of characters
            if (dic2.containsKey(c)) dic2.remove(c);
            dic2.put(c, i);
            System.out.println(dic2);
        }
    }
}
