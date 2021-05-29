package com.github.akovalchuk;

/**
 * Leetcode. 42. Trapping Rain Water
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int size = height.length;
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            int max = Math.min(leftMax[i], rightMax[i]);
            if (max > height[i]) {
                count += (max - height[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}) == 6);
        System.out.println(trap(new int[] {4,2,0,3,2,5}) == 9);
    }
}
