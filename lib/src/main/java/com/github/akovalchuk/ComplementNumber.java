package com.github.akovalchuk;

/**
 * Educative.io. Complement of Base 10 Number (medium)
 * 
 * Leetcode. 1009. Complement of Base 10 Integer
 * 
 * Leetcode. 476. Number Complement
 */
public class ComplementNumber {

    public static int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        return n ^ msb(n);
    }

    private static int msb(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n;
    }

    private static int msb2(int n) {
        int p = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) == mask) {
                p = i;
            }
        }
        return 1 << p;
    }

    public static void main(String args[]) {

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(Integer.highestOneBit(10)));
        System.out.println(Integer.toBinaryString(msb2(10)));
        System.out.println("--");
        System.out.println(Integer.toBinaryString((Integer.highestOneBit(10) << 1) - 1));
        System.out.println(Integer.toBinaryString(msb(10)));
        System.out.println(Integer.toBinaryString(msb(10) + 1));
        System.out.println("--");
        System.out.println("Bitwise complement is: " + bitwiseComplement(8)); // 7
        System.out.println("Bitwise complement is: " + bitwiseComplement(10)); // 5
    }

}
