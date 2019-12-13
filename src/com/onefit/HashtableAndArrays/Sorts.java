package com.onefit.HashtableAndArrays;


import java.lang.reflect.Array;

public class Sorts {

    public interface ISorter<T extends Comparable<T>> {
        void Sort(T[] array);
    }

    public static class BubbleSort<T extends Comparable<T>> implements ISorter<T> {
        public void Sort(T[] a) {
            for (int i = 0; i <a.length; i++) {
                for (int j = i; j < a.length; j++) {
                    if (a[i].compareTo(a[j]) > 0 ) {
                        T temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }

    public static class QuickSort<T extends Comparable<T>> implements ISorter<T> {
        public void Sort(T[] array) {
            SortRecursive(array, 0, array.length - 1);
        }

        private void SortRecursive(T[] array, int low, int high) {
            if (low < high) {
                int newPivotIndex = Partition(array, low, high);

                SortRecursive(array, low, newPivotIndex - 1);
                SortRecursive(array, newPivotIndex + 1, high);
            }
        }

        private int Partition(T[] array, int low, int high) {
            int biggerElementIndex = low;
            T pivot = array[high];
            for(int j = low; j < high; j++) {
                if (array[j].compareTo(pivot) <= 0) {

                    T temp = array[j];
                    array[j] = array[biggerElementIndex];
                    array[biggerElementIndex] = temp;

                    biggerElementIndex++;
                }
            }
            T temp = array[biggerElementIndex];
            array[biggerElementIndex] = array[high];
            array[high] = temp;
            return biggerElementIndex;
        }
    }

    public static void MergeSort(int[] a) {
        if (a.length == 1) {
            return;
        }
        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - left.length];
        for (int i = 0; i < a.length; i++ ) {
            if (i < left.length) {
                left[i] = a[i];
            } else {
                right[i - left.length] = a[i];
            }
        }
        MergeSort(left);
        MergeSort(right);
        Merge(a, left, right);
    }

    private static void Merge(int[] a, int[] left, int[] right) {
        int leftInd = 0;
        int rightInd = 0;
        int i = 0;
        while (leftInd < left.length && rightInd < right.length) {
            if (left[leftInd] < right[rightInd]) {
                a[i] = left[leftInd];
                leftInd++;
            }
            else {
                a[i] = right[rightInd];
                rightInd++;
            }
            i++;
        }
        while (leftInd < left.length) {
            a[i] = left[leftInd];
            i++;
            leftInd++;
        }
        while (rightInd < right.length) {
            a[i] = right[rightInd];
            i++;
            rightInd++;
        }
    }


    public static void main(String[] array) {
        int[] a = new int[] { 17, 15, 25, 32, 33, 34, 13, 31, 18 };
        int[] b = new int[] { 13, 15, 17, 18, 25, 31, 32, 33, 34 };

        //Sort(a, new QuickSort<>());
        MergeSort(a);
        assert AreArraysEqual(a, b);

        uniquePaths(3, 3);
    }

    public static int uniquePaths(int A, int B) {
        if (A == 1 || B == 1) {
            return 1;
        }
        return uniquePaths(A-1,B) + uniquePaths(A, B-1);
    }

    private static void Sort(Integer[] a, ISorter<Integer> strategy) {
        strategy.Sort(a);
    }

    private static boolean AreArraysEqual(int[] res, int[] b) {
        if (res.length != b.length) {
            return false;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
