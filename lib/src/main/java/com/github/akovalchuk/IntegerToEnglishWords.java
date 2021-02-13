package com.github.akovalchuk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntegerToEnglishWords {
    
    private Map<Integer, List<String>> dict = new HashMap<Integer, List<String>>() {{
        put(1, List.of("One"));
        put(2, List.of("Two", "Twenty"));
        put(3, List.of("Three", "Thirty"));
        put(4, List.of("Four", "Fourty"));
        put(5, List.of("Five", "Fifty"));
        put(6, List.of("Six", "Sixty"));
        put(7, List.of("Seven", "Seventy"));
        put(8, List.of("Eight", "Eighty"));
        put(9, List.of("Nine", "Ninety"));
        put(10, List.of("Ten"));
        put(11, List.of("Eleven"));
        put(12, List.of("Twelve"));
        put(13, List.of("Thirteen"));
        put(14, List.of("Fourteen"));
        put(15, List.of("Fiveteen"));
        put(16, List.of("Sixteen"));
        put(17, List.of("Seventeen"));
        put(18, List.of("Eighteen"));
        put(19, List.of("Nineteen"));
    }};
    
    private static final String TH = "Thousand";
    private static final String HU = "Hundred";
    private static final String MI = "Million";
    private static final String BI = "Billion";
    
    public String numberToWords(int num) {
        if (num < 0) return "Negative";
        if (num == 0) return "Zero";
        var list = new LinkedList<String>();
        int rank = 0;
        while (num > 0) {
            int un = num % 10;
            int tn = (num / 10) % 10;
            int hu = (num / 100) % 10;
            int nextThree = (num / 1000) % 1000;
            if (tn != 0 && tn == 1) {
                list.addFirst(dict.get(tn * 10 + un).get(0));
            } else if (tn == 0 && un != 0) {
                list.addFirst(dict.get(un).get(0));
            } else if (tn > 1) {
                if (un != 0) {
                    list.addFirst(dict.get(un).get(0));
                }
                list.addFirst(dict.get(tn).get(1));
            }
            if (hu != 0) {
                list.addFirst(HU);
                list.addFirst(dict.get(hu).get(0));
            }
            if (nextThree > 0) {
                switch (rank) {
                    case 0:
                        list.addFirst(TH);
                        break;
                    case 1:
                        list.addFirst(MI);
                        break;
                    case 2:
                        list.addFirst(BI);
                        break;
                }
            }
            num = num / 1000;
            rank++;
        }
        var result = new StringBuilder();
        var it = list.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            if (it.hasNext()) result.append(' ');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        var sol = new IntegerToEnglishWords();
        System.out.println(sol.numberToWords(1_234_567));
        System.out.println(sol.numberToWords(1_000));
        System.out.println(sol.numberToWords(1_000_000));
        System.out.println(sol.numberToWords(1_000_000_000));
        System.out.println(sol.numberToWords(1));
        System.out.println(sol.numberToWords(11));
        System.out.println(sol.numberToWords(111));
        System.out.println(sol.numberToWords(1_111));
        System.out.println(sol.numberToWords(11_111));
        System.out.println(sol.numberToWords(111_111));
        System.out.println(sol.numberToWords(1_111_111));
        System.out.println(sol.numberToWords(1_090_090_090));
    }

}
