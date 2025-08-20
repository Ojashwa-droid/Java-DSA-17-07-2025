package com.ojas.dsa.sorting.bubble;

import java.util.Arrays;

public class BubbleSortAlgo {
    public static void main(String[] args) {
//        int[] array = {4, 3, 2, 1, 5};
        int[] array = {1, 2, 3, 4, 5};
        BubbleSortAlgo.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {

        // Run the outer loop "length - 1" times
        for (int i = 0; i < array.length; i++) {
            boolean wasSwapped = false;
            // For each value of i the largest element will come to its respective last index
            for (int j = 1; j < array.length - i; j++) {
                // if the element before this element is greater, then swap
                if (array[j] < array[j - 1]) {
                    // swap the elements such that greater element comes after the smaller one
                    swap(array, j, j - 1);
                    wasSwapped = true;
                }
            }
            // If you did not swap for a particular value of i, it means the array is sorted
            if (!wasSwapped) {
                return;
            }
        }
    }

    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }
}
