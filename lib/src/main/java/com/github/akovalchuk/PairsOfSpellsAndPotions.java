package com.github.akovalchuk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** 
 * 2300. Successful Pairs of Spells and Potions
 */
class PairsOfSpellsAndPotions {
    public static void main(String[] args) throws Exception {
        long target = 0;
        List<Integer> spells = null;
        List<Integer> potions = null;
        List<Integer> expected = null;
        List<Integer> res = null;
        try (var is = new BufferedReader(new InputStreamReader(
                PairsOfSpellsAndPotions.class.getClassLoader().getResourceAsStream("pairs_of_spells_and_potions.txt")))) {
            var arrStr = is.readLine();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            spells = new ArrayList<Integer>();
            try (var scanner = new Scanner(arrStr)) {
                scanner.useDelimiter(",");
                while (scanner.hasNextInt()) {
                    spells.add(scanner.nextInt());
                }
            }
            arrStr = is.readLine();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            potions = new ArrayList<Integer>();
            try (var scanner = new Scanner(arrStr)) {
                scanner.useDelimiter(",");
                while (scanner.hasNextInt()) {
                    potions.add(scanner.nextInt());
                }
            }
            var targetStr = is.readLine();
            target = Long.parseLong(targetStr);
            arrStr = is.readLine();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            expected = new ArrayList<Integer>();
            try (var scanner = new Scanner(arrStr)) {
                scanner.useDelimiter(",");
                while (scanner.hasNextInt()) {
                    expected.add(scanner.nextInt());
                }
            }
            res = successfulPairs(spells, potions, target);
        }
        System.out.println("Result: " + compare(res, expected));
    }

    public static List<Integer> successfulPairs(List<Integer> spells, List<Integer> potions, long success) {
        if (spells == null || spells.size() == 0)
            return List.of();
        int n = spells.size();
        var res = new ArrayList<Integer>(n);
        if (potions == null || potions.size() == 0)
            return res;
        int m = potions.size();
        Collections.sort(potions);
        for (int i = 0; i < n; i++) {
            long candidate = success / spells.get(i) + (success % spells.get(i) > 0 ? 1 : 0);
            if (candidate > 100_000) {
                res.add(0);
                continue;
            }
            int idx = Collections.binarySearch(potions, (int) candidate);
            if (idx >= 0) {
                idx = binSearchLower(potions, (int) candidate);
                res.add(m - idx);
            } else {
                res.add(m + idx + 1);
            }
            if (res.get(i) == potions.size()) {
                System.out.println("i: " + i + " spells: " + spells.get(i) + " potions idx: " + idx + " potions: "
                        + (idx >= 0 ? potions.get(idx) : "None"));
            }
        }
        return res;
    }

    private static int binSearchLower(List<Integer> a, int v) {
        int b = 0;
        int e = a.size();
        while (b < e) {
            int m = b + (e - b) / 2;
            if (a.get(m) < v) {
                b = m + 1;
            } else {
                e = m;
            }
        }
        for (; b <= e; b++) {
            if (a.get(b) == v)
                return b;
        }
        return b;
    }

    private static boolean compare(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            System.out.println("a.size=" + a.size() + " b.size=" + b.size());
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                System.out.println("Not equal first: a(" + i + ")=" + a.get(i) + " != b(" + i + ")=" + b.get(i));
                return false;
            }
        }
        return true;
    }

}
