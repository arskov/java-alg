package com.github.akovalchuk;

import java.util.HashMap;
import static java.lang.System.out;

/**
 * 560. Subarray Sum Equals K
 */
public class SubArraySumEqualsK {
    
    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;
        int count = 0;
        int sum = 0;
        var sums = new HashMap<Integer, Integer>();
        sums.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.compute(sum, (key, val) -> val == null ? 1 : val + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        var sol = new SubArraySumEqualsK();
        out.println(sol.subarraySum(new int[] {1,1,1}, 2));
    }

}
