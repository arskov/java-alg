package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Leetcode. 301. Remove Invalid Parentheses
 */
public class RemoveInvalidParenthesis1 {
    
    private boolean isValid(String s) {
        if (s.isEmpty()) 
            return true;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                if (balance == 0)
                    return false;
                balance--;
            }
        }
        return balance == 0;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return List.of("");
        }
        List<String> result = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String tmp = queue.poll();
                if (isValid(tmp)) {
                    found = true;
                    result.add(tmp);
                } else {
                    for (int j = 0; j < tmp.length(); j++) {
                        if (tmp.charAt(j) == '(' || tmp.charAt(j) == ')') {
                            String newStr = tmp.substring(0, j) + tmp.substring(j + 1);
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
            if (found) break;
        }
        return result;
    }


    public static void main(String[] args) {
        var solution = new RemoveInvalidParenthesis1();
        System.out.println(solution.removeInvalidParentheses("((()()()"));
        System.out.println(solution.removeInvalidParentheses(")()()("));
        System.out.println(solution.removeInvalidParentheses("()())()"));
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
    }
}
