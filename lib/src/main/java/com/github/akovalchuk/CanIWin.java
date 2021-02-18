package com.github.akovalchuk;

/**
 * 464. Can I Win   
 */
public class CanIWin {
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        int[] memo = new int[(1 << maxChoosableInteger) + 1];
        return helper(0, maxChoosableInteger, desiredTotal, memo) == 1;
    }
    
    private int helper(int key, int max, int desire, int[] memo) {
        if (memo[key] != 0) return memo[key];
        for (int i = 0; i < max; i++) {
            int idx = 1 << i;
            if ((key & idx) == 0) {
                int newDesire = desire - (i + 1);
                if (newDesire <= 0) {
                    return 1;
                }
                key = key ^ idx;
                int res = -1 * helper(key, max, newDesire, memo);
                key = key ^ idx;
                if (res == 1) {
                    memo[key] = 1;
                    return 1;
                }
            }
        }
        memo[key] = -1;
        return - 1;
    }

    public static void main(String[] args) {
        var sol = new CanIWin();
        System.out.println(sol.canIWin(10, 11));
        System.out.println(sol.canIWin(4, 6));
        System.out.println(sol.canIWin(20, 210));
    }
}
