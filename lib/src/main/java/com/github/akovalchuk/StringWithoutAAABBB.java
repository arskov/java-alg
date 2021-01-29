package com.github.akovalchuk;

public class StringWithoutAAABBB {
    /*
    aa aa aa aa bbbbb = 5
                gaps = 3
                rem = 2
    abab abab (aa aa b)
    
    "aa aa aa" "bbb"
    split by 2 symbols
    take N - 1
    if N-1 equals b
        insert between
    if N-1 greater then b
        impossible
    if less
        take b - N - 1 parts
        insert b between letters in a part
        insert betwen
    */
    public String strWithout3a3b(int a, int b) {
        int greater = a;
        char greaterLetter = 'a';
        int lesser = b;
        char lesserLetter = 'b';
        if (a < b) {
            int tmp = greater;
            greater = lesser;
            lesser = tmp;
            char tmpLetter = greaterLetter;
            greaterLetter = lesserLetter;
            lesserLetter = tmpLetter;
        }
        var sb = new StringBuilder();
        while (lesser > 0) {
            if (lesser < greater) {
                sb.append(greaterLetter);
                sb.append(greaterLetter);
                sb.append(lesserLetter);
                lesser -= 1;
                greater -= 2;
            } else if (lesser == greater) {
                sb.append(greaterLetter);
                sb.append(lesserLetter);
                lesser -= 1;
                greater -=1;
            } else {
                throw new RuntimeException("Should not happen");
            }
        }
        while (greater > 0) {
            sb.append(greaterLetter);
            greater -= 1;
        }
        return sb.toString();
        /*
        int pairs = (int) Math.ceil( greater / 2 );
        int gaps = pairs - 1;
        if (gaps > lesser) {
            return null;
        } else if (gaps == lesser) {
            var sb = new StringBuilder();
            for (int i = 0; i < gaps; i++) {
                sb.append(greaterLetter);
                sb.append(greaterLetter);
                sb.append(lesserLetter);
            }
            sb.append(greaterLetter);
            sb.append(greaterLetter);
            return sb.toString();            
        } else {
            var sb = new StringBuilder();
            int remaining = lesser - gaps;
            for (int i = 0; i < remaining; i++) {
                sb.append(greaterLetter);
                sb.append(lesserLetter);
                sb.append(greaterLetter);
                if (i != (remaining - 1)) {
                    sb.append(lesserLetter);
                }
            }
            if ((pairs - remaining) > 0) {
                sb.append(lesserLetter);
                for (int i = 0; i < (pairs - remaining); i++) {
                    sb.append(greaterLetter);
                    sb.append(greaterLetter);
                    if ((i + 1) != (pairs - remaining)) {
                        sb.append(lesserLetter);
                    }
                }
            }
            return sb.toString();
        }
        */
    }

    public static void main(String[] args) {
        var solution = new StringWithoutAAABBB();
        System.out.println(solution.strWithout3a3b(1, 2));
        System.out.println(solution.strWithout3a3b(4, 1));
    }
}
