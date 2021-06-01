package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *  Leetcode. 1197. Minimum Knight Moves
 */
public class MinKnightMoves2 {

    static class Point {
        
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
        
        public boolean equals(Object other) {
            if (other instanceof Point) {
                Point o = (Point) other;
                return this.x == o.x && this.y == o.y;
            }
            return false;
        }
        
    }

    private static Map<Point, Integer> memo = new HashMap<>();

    public static int minKnightMoves(int x, int y) {
        return helper(Math.abs(x), Math.abs(y));
    }
    
    public static int helper(int x, int y) {
        if (x + y == 0) return 0;
        if (x + y == 2) return 2;
        var p = new Point(x, y);
        if (memo.containsKey(p)) return memo.get(p);
        int r = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2)), helper(Math.abs(x - 2), Math.abs(y - 1))) + 1;
        memo.put(p, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(-76, 144) == 74);
    }
}
