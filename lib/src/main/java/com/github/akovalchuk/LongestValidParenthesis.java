package com.github.akovalchuk;

import java.util.ArrayDeque;

public class LongestValidParenthesis {

    public int longestValidParentheses1(String s) {
        if (s == null || s.length() <= 1) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            dp[1] = 2;
            max = 2;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                dp[i] = dp[i - 2] + 2;
            } else if (s.charAt(i - 1) == ')' && s.charAt(i) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) return 0;
        int max = 0;
        var stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
             }
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new LongestValidParenthesis();
        var test1 = ")(((((()())()()))()(()))(";
        System.out.println(sol.longestValidParentheses1(test1));
        System.out.println(sol.longestValidParentheses2(test1));
    }
}
