package com.github.akovalchuk;

/**
 * Educative.io. Minimum Deletions to Make a Sequence Sorted
 * <p>
 * Given a number sequence, find the minimum number of elements that should be
 * deleted to make the remaining sequence sorted.
 */
public class MinDeletionsSequenceSorted {

    public static int findMinimumDeletions(int[] nums){
        if (nums == null || nums.length == 0)
          return 0;
        Integer[][] memo = new Integer[nums.length][nums.length];
        return find(nums, -1, 0, memo);
      }
    
      private static int find(int[] nums, int prev, int next, Integer[][] memo) {
        if (next == nums.length)
          return 0;
        if (prev != -1 && memo[prev][next] != null) {
          return memo[prev][next];
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (prev == -1 || nums[prev] < nums[next]) {
          a = find(nums, next, next + 1, memo);
        }
        b = 1 + find(nums, prev, next + 1, memo);
        int res = Math.min(a, b);
        if (prev != -1) {
          memo[prev][next] = res;
        }
        return res;
      }
    
      public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(findMinimumDeletions(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(findMinimumDeletions(nums));
        nums = new int[]{3,2,1,0};
        System.out.println(findMinimumDeletions(nums));
      }

}
