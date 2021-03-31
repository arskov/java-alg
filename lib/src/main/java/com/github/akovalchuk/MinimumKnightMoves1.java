package com.github.akovalchuk;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;

/**
 * 1197. Minimum Knight Moves 
 * 
 * This is not optimal BFS solution
 */
public class MinimumKnightMoves1 {

    static class Point {
        
        int x;
        int y;
        
        int move;
        
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
        
        public Point next(int[] move) {
            return new Point(this.x + move[0], this.y + move[1]);
        }
    }
    
    private static int[][] moves = {
        {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };
    
    public static int minKnightMoves(int x, int y) {
        var queue = new ArrayDeque<Point>();
        var visited = new HashSet<Point>();
        var start = new Point(0, 0);
        var end = new Point(x, y);
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            if (cur.equals(end)) return cur.move;
            for (var move : moves) {
                var next = cur.next(move);
                if (Math.abs((Math.abs(x) - Math.abs(cur.x)) - (Math.abs(x) - Math.abs(next.x))) > 2) continue;
                if (Math.abs((Math.abs(y) - Math.abs(cur.y)) - (Math.abs(y) - Math.abs(next.y))) > 2) continue;
                if (!visited.contains(next)) {
                    next.move = cur.move + 1;
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minKnightMoves(-76, 144) == 74);
    }
}
