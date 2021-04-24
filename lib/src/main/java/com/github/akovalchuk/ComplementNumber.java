package com.github.akovalchuk;

/**
 * <p>
 * Educative.io. Complement of Base 10 Number (medium)
 * <p>
 * Leetcode. 1009. Complement of Base 10 Integer
 * <p>
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

    public static void main(String args[]) {
        System.out.println("Bitwise complement is: " + bitwiseComplement(8)); // 7
        System.out.println("Bitwise complement is: " + bitwiseComplement(10)); // 5
    }

}
