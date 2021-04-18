package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Educative.io. Evaluate Expression (hard)
 * 
 * Leetcode. 241. Different Ways to Add Parentheses
 */
public class DifferentWaysAddParentheses {

    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression == null)
            return Collections.emptyList();
        Map<String, List<Integer>> memo = new HashMap<>();
        return helper(expression, memo);
    }

    private static List<Integer> helper(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression))
            return memo.get(expression);
        List<Integer> result = new ArrayList<>();
        int dig = 0;
        boolean isDigitOnly = true;
        for (int i = 0; i < expression.length(); i++) {
            int c = expression.charAt(i) - '0';
            if (c < 0 || c > 9) {
                isDigitOnly = false;
            }
            dig = dig * 10 + c;
        }
        if (isDigitOnly) {
            result.add(dig);
            memo.put(expression, result);
            return result;
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> left = helper(expression.substring(0, i), memo);
                List<Integer> right = helper(expression.substring(i + 1), memo);
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                        case '*':
                            result.add(l * r);
                            break;
                        case '+':
                            result.add(l + r);
                            break;
                        case '-':
                            result.add(l - r);
                            break;
                        }
                    }
                }
            }
        }
        memo.put(expression, result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = diffWaysToCompute("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = diffWaysToCompute("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
