package com.github.akovalchuk;

/**
 * Educative.io. Next Letter (medium)
 */
public class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        if (letters == null || letters.length == 0)
            return '0';
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] == key) {
                return mi < letters.length - 1 ? letters[mi + 1] : letters[0];
            } else if (key < letters[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return lo >= letters.length ? letters[0] : letters[lo];
    }

    public static void main(String[] args) {
        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }

}
