package com.github.akovalchuk;

/**
 * 678. Valid Parenthesis String
 * 
 * "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
 *   
 */
public class ValidParenthesisBacktrack {

    private static boolean result;
    
    public static boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) return false;
        result = false;
        var sb = new StringBuilder(s);
        check(sb, 0);
        return result;
    }

    private static void check(StringBuilder sb, int i) {
        if (result) return;
        if (i == sb.length()) {
            if (result == false) {
                result = result || valid(sb);
            }
            return;
        }
        for (int j = i; j < sb.length(); j++) {
            char c = sb.charAt(j);
            if (c == '*') {
                sb.setCharAt(j, '(');
                check(sb, j + 1);
                sb.setCharAt(j, ')');
                check(sb, j + 1);
                sb.setCharAt(j, '*');
            }
        }
        result = result || valid(sb);
    }

    private static boolean valid(StringBuilder sb) {
        int balance = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        var test1 = "()";
        System.out.println(checkValidString(test1));
        var test2 = "(*))";
        System.out.println(checkValidString(test2));
        var test3 = "((***))";
        System.out.println(checkValidString(test3));
        var test4 = "(*)";
        System.out.println(checkValidString(test4));
        var test5 = "(*(";
        System.out.println(checkValidString(test5));
        var test20 = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString(test20));
        var test30 = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidString(test30));
    }

}
