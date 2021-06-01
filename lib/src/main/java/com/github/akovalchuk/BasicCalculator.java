package com.github.akovalchuk;

import java.util.ArrayDeque;

/**
 * Leetcode. 224. Basic Calculator
 */
public class BasicCalculator {
    
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        return calculate(s, 0)[0];
    }
    
    private int[] calculate(String s, int start) {
        var deque = new ArrayDeque<Integer>();
        char prevOp = 0;
        int buf = 0;
        outer:
        while (start < s.length()) {
            char c = s.charAt(start);
            switch(c) {
                case '(':
                    int[] tmp = calculate(s, start + 1);
                    buf = tmp[0];
                    start = tmp[1];
                    break;
                case '+':
                case '-':
                    if (prevOp == '-')
                        deque.push(-buf);
                    else
                        deque.push(buf);
                    buf = 0;
                    prevOp = c;
                    break;
                case ')':
                    break outer;
                case ' ':
                    break;
                default:
                    buf = buf * 10 + (c - '0');
            }
            start++;
        }
        if (prevOp == '-')
            deque.push(-buf);
        else
            deque.push(buf);
        int res = 0;
        while (!deque.isEmpty()) res += deque.pop();
        return new int[] {res, start};
    }

    public static void main(String[] args) {
        var s = new BasicCalculator();
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
