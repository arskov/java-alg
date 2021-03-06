package com.github.akovalchuk;

import static java.lang.System.out;

public class BitTricks {

    public static String binaryToString16bit(int val) {
        return String.format("%16s", Integer.toBinaryString(val)).replace(' ', '0');
    }

    public static String binaryToString32bit(int val) {
        return String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
    }

    public static void cyclic_xor() {
        int tmp = 0;
        for (int i = 0; i < 10; i++) {
            tmp ^= 1;
            out.println(binaryToString16bit(tmp));
        }
    }

    /**
     * Cleares the last set bit
     * @param x
     */
    public static void x_and_x_minus_one_1(int x) {
        out.println(binaryToString16bit(x));
        out.println(binaryToString16bit(x - 1));
        x = x & (x - 1);
        out.println(binaryToString16bit(x));
    }

    /**
     * Removes all set bits exept the last one
     * @param x
     */
    public static void x_and_x_minus_one_2(int x) {
        out.println(binaryToString16bit(x));
        out.println(binaryToString16bit(x - 1));
        out.println(binaryToString16bit(~(x - 1)));
        x = x & (~(x-1));
        out.println(binaryToString16bit(x));
    }

    /**
     * The number of the power of two has the only one set bit
     * @param x
     */
    public static boolean is_pow_of_two(int x) {
        return ((x & (~(x - 1))) ^ x) == 0;
    }


    public static void main(String[] args) {
        cyclic_xor();
        out.println("-----");
        x_and_x_minus_one_1(122);
        out.println("-----");
        x_and_x_minus_one_1(124);
        out.println("-----");
        x_and_x_minus_one_2(124);
        out.println("-----");
        out.println(is_pow_of_two(64));
        out.println(is_pow_of_two(60));
        out.println(is_pow_of_two(63));
    }
    
}
