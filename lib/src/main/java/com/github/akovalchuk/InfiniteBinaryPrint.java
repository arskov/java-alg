package com.github.akovalchuk;

public class InfiniteBinaryPrint {

    public void printBinary(int times) {
        if (times <=  0) return;
        int counter = 0b10;
        for (int i = counter; times > 0; i++, times--) {
            System.out.println(Integer.toBinaryString(i).substring(1));
        }
    }
    
    public static void main(String[] args) {
        var sol = new InfiniteBinaryPrint();
        sol.printBinary(100);
    }
}
