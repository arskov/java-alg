package com.github.akovalchuk;

import java.util.ArrayDeque;

/**
 * 678. Valid Parenthesis String
 * 
 * "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
 *   
 */
public class ValidParenthesisStack {
    
    public static boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) return false;
        int len = s.length();
        var stack1 = new ArrayDeque<Integer>();
        var stack2 = new ArrayDeque<Integer>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.push(i);
            } else if (c == ')') {
                if (!stack1.isEmpty()) {
                    stack1.poll();
                } else if (!stack2.isEmpty()) {
                    stack2.poll();
                } else {
                    return false;
                }
            } else {
                stack2.push(i);
            }
        }
        boolean found = true;
        while (!stack1.isEmpty()) {
            int leftBracketIdx = stack1.pop();
            found = false;
            while (!stack2.isEmpty()) {
                int starIdx = stack2.pop();
                if (starIdx > leftBracketIdx) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return found;
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
