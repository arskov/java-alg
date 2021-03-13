package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 249. Group Shifted Strings
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null) return Collections.emptyList();
        var map = new HashMap<String, List<String>>();
        for (var s : strings) {
            var chDiff = charDiff(s);
            var list = map.getOrDefault(chDiff, new ArrayList<String>());
            list.add(s);
            map.put(chDiff, list);
        }
        var result = new ArrayList<List<String>>();
        for (var e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
    
    private String charDiff(String s) {
        var sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            int c1 = s.charAt(i) - 'a';
            int c2 = s.charAt(i + 1) - 'a';
            if (c1 < c2) {
                sb.append(c1 + 26 - c2);
            } else {
                sb.append(c1 - c2);
            }
        }
        if (sb.length() == 0) sb.append('-');
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new GroupShiftedStrings();
        String[] test = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(solution.groupStrings(test));
    }
    
}
