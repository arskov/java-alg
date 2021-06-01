package com.github.akovalchuk;

import java.util.ArrayDeque;

/**
 * Leetcode. 227. Basic Calculator II
 */
public class BasicCalculator2 {
    
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        var deque = new ArrayDeque<Integer>();
        var opDeque = new ArrayDeque<Character>();
        var buf = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '-':
                case '+':
                case '*':
                case '/':
                    int n = Integer.parseInt(buf.toString());
                    buf.setLength(0);
                    deque.push(n);
                    if (!opDeque.isEmpty()) {
                        if (opDeque.peek() == '*') {
                            deque.push(deque.pop() * deque.pop());
                            opDeque.pop();
                        } else if (opDeque.peek() == '/') {
                            int b = deque.pop();
                            deque.push(deque.pop() / b);
                            opDeque.pop();
                        }
                    }
                    opDeque.push(c);
                    break;
                case ' ':
                    break;
                default:
                    buf.append(c);
            }
        }
        int n = Integer.parseInt(buf.toString());
        deque.push(n);
        if (!opDeque.isEmpty()) {
            if (opDeque.peek() == '*') {
                deque.push(deque.pop() * deque.pop());
                opDeque.pop();
            } else if (opDeque.peek() == '/') {
                int b = deque.pop();
                deque.push(deque.pop() / b);
                opDeque.pop();
            }
        }
        int res = deque.pollLast();
        while (!deque.isEmpty()) {
            int b = deque.pollLast();
            char op = opDeque.pollLast();
            if (op == '+') {
                res += b;
            } else if (op == '-') {
                res -= b;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new BasicCalculator2();
        var test1 = " 3+5 / 2 ";
        var test2 = "3+2*2";
        System.out.println(s.calculate(test1));
        System.out.println(s.calculate(test2));
    }
}
