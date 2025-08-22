package com.ojas.dsa.sorting;

import java.util.Arrays;

public class CyclicSortAlgo {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1, 5};
        CyclicSortAlgo.cycleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void cycleSort(int[] array){
        // Since, elements in the array are from 1 to N
        // after being sorted, the elements will be at their right index; with index = element - 1
        int i = 0;
        while (i < array.length){
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]){
                // swap with the element at its index
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }
    }
    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }

}
