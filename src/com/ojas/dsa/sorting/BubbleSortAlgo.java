package com.ojas.dsa.sorting;

import java.util.Arrays;

public class BubbleSortAlgo {
    public static void main(String[] args) {
//        int[] array = {4, 3, 2, 1, 5};
//        int[] array = {1, 2, 3, 4, 5};
        int[] array = {3, 1, 5, 4, 2};
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


   /* public static void bubbleSortAlgo(int[] array){
        // We have n - 1 number of passes for sorting the array
        for (int i = 0; i < array.length; i++) {
            boolean wasSwapped = false;
            // For each pass (meaning value of i), the largest element sits at the respective
            // last index
            // meaning in the first pass -> the first largest index will be at the first last index and so on
            // and after every pass, the array gets sorted from the end, so we can ignore that part of the array
            for (int j = 1; j < array.length - i; j++) {
                // if the current element is smaller than the previous element - swap
                if (array[j] < array[j -1]){
                    swap(array, j, j-1);
                    wasSwapped = true;
                }
            }
            if (!wasSwapped){
                return;
            }
        }
    }*/
}
