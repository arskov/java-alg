package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Educative.io. Balanced Parentheses (hard)
 * 
 * Leetcode. 22. Generate Parentheses
 */
public class GenerateParentheses {

    public static class Holder {
        StringBuilder sb;
        int opened;
        int closed;

        public Holder(String s) {
            this.sb = new StringBuilder(s);
        }

        public Holder(String s, int opened, int closed) {
            this.sb = new StringBuilder(s);
            this.opened = opened;
            this.closed = closed;
        }
    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        LinkedList<Holder> queue = new LinkedList<>();
        queue.offer(new Holder(""));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Holder tmp = queue.poll();
                if (tmp.opened == num && tmp.closed == num) {
                    result.add(tmp.sb.toString());
                    continue;
                }
                Holder tmp1 = new Holder(tmp.sb.toString(), tmp.opened, tmp.closed);
                if (tmp.opened < num) {
                    tmp.sb.append('(');
                    tmp.opened++;
                    queue.offer(tmp);
                }
                if (tmp1.opened > tmp1.closed) {
                    tmp1.sb.append(')');
                    tmp1.closed++;
                    queue.offer(tmp1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

}
