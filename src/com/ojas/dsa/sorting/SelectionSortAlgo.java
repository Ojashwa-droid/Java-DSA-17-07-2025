package com.ojas.dsa.sorting;

import java.util.Arrays;

public class SelectionSortAlgo {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1, 5};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int lastIndex = array.length - i - 1; // current last index of unsorted part of the array
            int maxIndex = 0;
            for (int j = 0; j < array.length - i ; j++) {
                if (array[j] > array[maxIndex]){
                    maxIndex = j;
                }
            }
            // swap the max element with the last respective index
            swap(array, maxIndex, lastIndex);
        }
    }

    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }
}
