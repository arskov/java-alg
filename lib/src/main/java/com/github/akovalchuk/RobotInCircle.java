package com.github.akovalchuk;

/**
 * Leetcode. 1041. Robot Bounded In Circle
 */
public class RobotInCircle {

    private static int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static boolean isRobotBounded(String instructions) {
        int[] curPoint = {0, 0};
        int curDirIdx = 0;
        int[] curDir = dirs[curDirIdx];
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                curPoint[0] += curDir[0];
                curPoint[1] += curDir[1];
            } else if (c == 'R') {
                curDirIdx = (curDirIdx + 1) % 4;
                curDir = dirs[Math.abs(curDirIdx)];
            } else if (c == 'L') {
                curDirIdx = (curDirIdx - 1) % 4;
                curDir = dirs[Math.abs(curDirIdx)];
            }
        }
        boolean isNorth = curDirIdx == 0;
        if (isNorth) {
            if (curPoint[0] == 0 && curPoint[1] == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG")); // true
        System.out.println(isRobotBounded("GG")); // false
        System.out.println(isRobotBounded("GL")); // true
    }
    
}
