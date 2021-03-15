package com.github.akovalchuk;

/**
 * 825. Friends Of Appropriate Ages
 */
public class FriendsOfAge {

    public static int numFriendRequests1(int[] ages) {
        if (ages == null || ages.length == 0) return 0;
        int[] dict = new int[121];
        for (int i = 0; i < ages.length; i++) {
            dict[ages[i]]++;
        }
        int counter = 0;
        for (int i = 0; i < ages.length; i++) {
            int lo = ages[i] / 2 + 7;
            int hi = ages[i];
            for (int j = 1; j <= 120; j++) {
                if (j <= lo || j > hi || (j > 100 && hi < 100)) continue; 
                counter += dict[j];
                if (j == ages[i]) counter--;
            }
        }
        return counter;
    }

    public static int numFriendRequests2(int[] ages) {
        if (ages == null || ages.length == 0) return 0;
        int[] dict = new int[121];
        for (int i = 0; i < ages.length; i++) {
            dict[ages[i]]++;
        }
        int counter = 0;
        for (int i = 1; i < 121; i++) {
            int tmp = i / 2 + 7;
            for (int j = 1; j < 121; j++) {
                if (j <= tmp || j > i || (j > 100 && i < 100)) continue;
                counter += dict[i] * dict[j];
                if (i == j) counter -= dict[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] t1 = {16,16};
        System.out.println(numFriendRequests1(t1));
        System.out.println(numFriendRequests2(t1));
        int[] t2 = {16,17,18};
        System.out.println(numFriendRequests1(t2));
        System.out.println(numFriendRequests2(t2));
        int[] t3 = {20,30,100,110,120};
        System.out.println(numFriendRequests1(t3));
        System.out.println(numFriendRequests2(t3));
        int[] t4 = {108,115,5,24,82};
        System.out.println(numFriendRequests1(t4));
        System.out.println(numFriendRequests2(t4));

    }
    
}
