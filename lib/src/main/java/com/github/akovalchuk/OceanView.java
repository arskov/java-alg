package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1762. Buildings With an Ocean View
 */ 
public class OceanView {

    public static int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) return new int[0];
        int len = heights.length;
        List<Integer> res = new ArrayList<>();
        int[] maxSoFar = new int[len];
        maxSoFar[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            maxSoFar[i] = Math.max(maxSoFar[i + 1], heights[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            if (heights[i] > maxSoFar[i]) {
                res.add(i);
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBuildings(new int[] {4,2,3,1})));
        System.out.println(Arrays.toString(findBuildings(new int[] {4,3,2,1})));
        System.out.println(Arrays.toString(findBuildings(new int[] {1,3,2,4})));
    }
    
}
