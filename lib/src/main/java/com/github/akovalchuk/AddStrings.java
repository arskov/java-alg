package com.github.akovalchuk;

/**
 * Leetcode. 415. Add Strings
 */
public class AddStrings {
    
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num2.length() < num1.length()) {
            return addStrings(num2, num1);
        }
        var sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        for ( ; i >= 0; i--, j--) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        for ( ; j >= 0; j--) {
            int sum = (num2.charAt(j) - '0') + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var s = new AddStrings();
        System.out.println(s.addStrings("124", "34"));
    }

}
