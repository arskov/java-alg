package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionAddOperators {

    private static final String[] OPS = { "+", "-", "*" };

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() < 2)
            return Collections.emptyList();
        List<String> expr = helper(num);
        expr.add(num);
        var res = new ArrayList<String>();
        for (var ex : expr) {
            if (target == calculate(ex)) 
                res.add(ex);
        }
        return res;
    }

    protected List<String> helper(String num) {
        if (num.length() == 0)
            return Collections.emptyList();
        var res = new ArrayList<String>();
        for (int i = 1; i < num.length(); i++) {
            var a = num.substring(0, i);
            var b = num.substring(i);
            if (a.length() > 1 && a.startsWith("0")) continue;
            var listC = helper(b);
            for (var op : OPS) {
                if (b.length() == 1 || (b.length() > 1 && !b.startsWith("0"))) 
                    res.add(a + op + b);
                for (var c : listC) {
                    res.add(a + op + c);
                }
            }
        }
        return res;
    }

    protected int calculate(String num) {
        var deque = new ArrayDeque<Integer>();
        var opDeque = new ArrayDeque<Character>();
        var numBuf = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char a = num.charAt(i);
            switch (a) {
                case '+':
                case '-':
                case '*':
                    int n = Integer.MAX_VALUE;
                    try {
                        n = Integer.parseInt(numBuf.toString());
                    } catch (NumberFormatException ex) {}
                    deque.push(n);
                    if (!opDeque.isEmpty() && opDeque.peek() == '*') {
                        deque.push(deque.pop() * deque.pop());
                        opDeque.pop();
                    }
                    opDeque.push(a);
                    numBuf.setLength(0);
                    break;
                default:
                numBuf.append(a);
            }
        }
        int n = Integer.MAX_VALUE;
        try {
            n = Integer.parseInt(numBuf.toString());
        } catch (NumberFormatException e) {}
        deque.push(n);
        if (!opDeque.isEmpty() && opDeque.peek() == '*') {
            deque.push(deque.pop() * deque.pop());
            opDeque.pop();
        }
        int result = deque.pollLast();
        while (!deque.isEmpty()) {
            int b = deque.pollLast();
            char op = opDeque.pollLast();
            if (op == '+') {
                result += b;
            } else if (op == '-') {
                result -= b;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var s = new ExpressionAddOperators();
        // System.out.println(s.calculate("2+3*2"));
        // var res = s.helper("232");
        // for (var r : res) {
        //     System.out.println(r + " = " + s.calculate(r));
        // }
        // System.out.println("-----");
        // var test1 = "232";
        // var target1 = 8;
        // System.out.println(s.addOperators(test1, target1));
        // System.out.println("-----");
        // var test2 = "105";
        // var target2 = 5;
        // System.out.println(s.addOperators(test2, target2));
        // var test3 = "123";
        // var target3 = 6;
        // System.out.println(s.addOperators(test3, target3));
    }

}
