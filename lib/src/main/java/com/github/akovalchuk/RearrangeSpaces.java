package com.github.akovalchuk;

import java.util.ArrayList;

/**
 * Leetcode. 1592. Rearrange Spaces Between Words
 */
public class RearrangeSpaces {

    public static String reorderSpaces(String text) {
        if (text == null || text.length() == 0) return text;
        var sb = new StringBuilder();
        var tmp = new ArrayList<String>();
        int len = text.length();
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaceCount++;
                if (sb.length() > 0) {
                    tmp.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) tmp.add(sb.toString());
        sb.setLength(0);
        int gap = tmp.size() == 1 ? 0 : spaceCount / (tmp.size() - 1);
        int rem = tmp.size() == 1 ? spaceCount : spaceCount % (tmp.size() - 1);
        for (int i = 0; i < tmp.size(); i++) {
            sb.append(tmp.get(i));
            if (i != tmp.size() - 1) {
                for (int j = 0; j < gap; j++) sb.append(' ');
            }
        }
        for (int j = 0; j < rem; j++) sb.append(' ');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("'" + reorderSpaces("  this   is  a sentence ") + "'");
        System.out.println("'" + reorderSpaces(" practice   makes   perfect") + "'");
    }
}
