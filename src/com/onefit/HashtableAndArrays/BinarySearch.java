package com.onefit.HashtableAndArrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = { 1 ,2 , 3, 4, 5, 6, 7, 8, 9, 10};

        int index = SearchBinary(a, 5);
    }

    private static int SearchBinary(int[] a, int i) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int middleIndex = (end + start) / 2;
            int midValue = a[middleIndex];
            if (i == midValue) {
                return middleIndex;
            }
            if (i > midValue) {
                start = middleIndex;
            } else {
                end = middleIndex;
            }
        }
        return -1;
    }
}
