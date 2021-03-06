package com.github.akovalchuk;

/**
 * 29. Divide Two Integers
 */
public class DivideIntegers {

    private static final int HALF_MIN_INT = Integer.MIN_VALUE / 2;

    public static int divide_1(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int count = 1;
        int prevCount = 1;
        int prev = divisor;
        int curr = divisor;
        while (curr > dividend && curr < 0) {
            prev = curr;
            prevCount = count;
            curr = -((-curr) + (-curr));
            count += count;
        }
        count = prevCount;
        curr = prev;
        while (curr >= dividend && curr < 0) {
            curr = -((-curr) + (-divisor));
            count += 1;
        }
        count--;
        if (count < 0) return Integer.MAX_VALUE;
        return negative ? -count : count;
    }

    public static int divide_2(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int totalCount = 0;
        while (divisor >= dividend) {
            int count = 1;
            int value = divisor;
            while (value >= HALF_MIN_INT && value + value > dividend) {
                value += value;
                count += count;
            }
            totalCount += count;
            dividend -= value;
        }
        return negative ? -totalCount : totalCount;
    }

    public static void main(String[] args) {
        System.out.println( divide_1(Integer.MIN_VALUE, 123_123_123) == Integer.MIN_VALUE / 123_123_123 );
        System.out.println( divide_2(Integer.MIN_VALUE, 123_123_123) == Integer.MIN_VALUE / 123_123_123 );
        System.out.println( divide_1(120, 6));
        System.out.println( divide_2(120, 6));
        System.out.println( divide_1(Integer.MIN_VALUE / 3, 3));
        System.out.println( divide_2(Integer.MIN_VALUE / 3, 3));
    }
}
