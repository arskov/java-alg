package com.github.akovalchuk;

/**
 * 65. Valid Number
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        return isDecimal(s) || isInteger(s);
    }
    
    private static boolean isDecimal(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        boolean digitFound = false;
        boolean dotFound = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (dotFound) return false;
                else dotFound = true;
            } else if (c == 'e' || c == 'E') {
                if (!digitFound) return false;
                return isInteger(s.substring(i + 1));
            } else if (!Character.isDigit(c)) {
                return false;
            } else {
                if (!digitFound) digitFound = true;
            }
        }
        return dotFound ? dotFound && digitFound : digitFound;
    }
    
    private static boolean isInteger(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // valid
        System.out.println(isNumber("-123.456e789"));
        System.out.println(isNumber("0089"));
        System.out.println(isNumber("-0.1"));
        System.out.println(isNumber("+3.14"));
        System.out.println(isNumber("-.9"));
        System.out.println(isNumber("+6e-1"));
        // invalid
        System.out.println(isNumber(""));
        System.out.println(isNumber("."));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("e2"));
        System.out.println(isNumber("99e2.5"));
        System.out.println(isNumber("1e-2."));
    }

}
