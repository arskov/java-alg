package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    
    static Map<Character, List<Character>> dic = Map.of(
        '2', List.of('a','b','c'),
        '3', List.of('d','e','f'),
        '4', List.of('g','h','i'),
        '5', List.of('j','k','l'),
        '6', List.of('m','n','o'),
        '7', List.of('p','q','r','s'),
        '8', List.of('t','u','v'),
        '9', List.of('w','x','y','z')
    );
    
    private void generate(List<String> out, StringBuilder sb, String digits, int pos) {
        if (pos == digits.length()) {
            out.add(sb.toString());
            return;
        }
        for (char c : dic.get(digits.charAt(pos))) {
            sb.append(c);
            generate(out, sb, digits, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return List.of();
        List<String> out = new ArrayList<>();
        var buf = new StringBuilder(digits.length());
        generate(out, buf, digits, 0);
        return out;
    }

    public static void main(String[] args) {
        var solution = new LetterCombinationsPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }
}
