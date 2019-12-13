package com.onefit.Strings;

import java.util.ArrayList;
import java.util.Collections;

public class Multiply {
    public String multiply(String A, String B) {
        if (A.equals("0") || B.equals("0")) {
            return "0";
        }
        // 123 89
        // 3 2 1 * 9 8 -> 7 0 1 1 + 0 3 2 1 * 8 -> 7 0 1 1 + 0 4 8 9
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        boolean nonZeroFound = false;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!nonZeroFound && ch == '0') {
                continue;
            }
            nonZeroFound = true;
            a.add(Character.getNumericValue(ch));
        }
        nonZeroFound = false;
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (!nonZeroFound && ch == '0') {
                continue;
            }
            nonZeroFound = true;
            b.add(Character.getNumericValue(ch));
        }

        if (a.size() == 0 || b.size() == 0) {
            return "0";
        }

        Collections.reverse(a);
        Collections.reverse(b);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            if (i == 0) {
                result = mult(a, b.get(i));
            }
            else {
                a.add(0, 0);
                result = plus(result, mult(a, b.get(i)));
            }
        }

        StringBuilder resultText = new StringBuilder();

        for (int i = result.size() - 1; i >= 0 ; i--) {
            resultText.append(result.get(i));
        }

        return resultText.toString();
    }
    // 3 2 1 * 9 -> 7 0 1 1
    public ArrayList<Integer> mult(ArrayList<Integer> a, int num) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftOver = 0;
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i) * num + leftOver;
            if (val > 9) {
                leftOver = val / 10;
                val = val % 10;
            }
            else {
                leftOver = 0;
            }
            result.add(val);
        }
        if (leftOver != 0) {
            while (leftOver > 0) {
                result.add(leftOver % 10);
                leftOver = leftOver / 10;
            }
        }
        return result;
    }

    // 8 0 9 + 0 2 1 -> 8 2 0 1
    public ArrayList<Integer> plus(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();

        int size = Math.max(a.size(), b.size());
        int leftOver = 0;
        for (int i = 0; i < size; i++) {
            int f = i >= a.size() ? 0 : a.get(i);
            int s = i >= b.size() ? 0 : b.get(i);

            int val = f + s + leftOver;
            if (val > 9) {
                leftOver = val / 10;
                val = val % 10;
            }
            else {
                leftOver = 0;
            }
            result.add(val);
        }
        if (leftOver != 0) {
            result.add(leftOver);
        }
        return result;
    }
}

