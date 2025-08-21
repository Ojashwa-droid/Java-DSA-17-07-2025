package com.ojas.dsa.sorting;

import java.util.Arrays;

public class InsertionSortAlgo {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 2};
        insertionSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void insertionSort(int[] array) {
        // In insertion sort we basically sort in parts
        // In each step (pass), we sort a portion of array from the left and repeat till the array is sorted
        // After the first pass (i = 0), array will be sorted till index no 1
        // Outer loop will be responsible for the number of passes, and will run till "length - 2" times
        for (int i = 0; i < array.length - 1; i++) {
            // The inner loop is responsible to ensure that the left of the current index is sorted
            // the inner loop index will always start from "i + 1" and decrement and in all cases j > 0,
            // else array index out of bound error
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    // swap
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }
}
