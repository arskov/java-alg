package com.github.akovalchuk;

/**
 * Leetcode. 844. Backspace String Compare
 * 
 * Educative.io. Comparing Strings containing Backspaces (medium)
 */
public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int p1 = str1.length() - 1;
        int bs1 = 0;
        int p2 = str2.length() - 1;
        int bs2 = 0;
        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (str1.charAt(p1) == '#') {
                    bs1++;
                    p1--;
                } else if (bs1 > 0) {
                    bs1--;
                    p1--;
                } else {
                    break;
                }
            }
            while (p2 >= 0) {
                if (str2.charAt(p2) == '#') {
                    bs2++;
                    p2--;
                } else if (bs2 > 0) {
                    bs2--;
                    p2--;
                } else {
                    break;
                }
            }
            if (p1 >= 0 && p2 >= 0 && str1.charAt(p1) != str2.charAt(p2)) 
                return false;
            if ((p1 >= 0) != (p2 >= 0))
                return false;
            p1--;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(compare("xywrrmp", "xywrrmu#p") == true);
        System.out.println(compare("xy#z", "xzz#") == true);
        System.out.println(compare("xy#z", "xyz#") == false);
        System.out.println(compare("bbbextm", "bbb#extm") == false);
    }

}
