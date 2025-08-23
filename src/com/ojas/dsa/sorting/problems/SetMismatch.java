package com.ojas.dsa.sorting.problems;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 2};
        System.out.println(Arrays.toString(findErrorNums(array)));

    }

    public static int[] findErrorNums(int[] array) {
        // First sort the given array using cycle sort, cause range [1, N]
        int i = 0;
        while (i < array.length) {
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]) {
                // swap
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        } // Now the array is sorted

        // In this sorted array, each element is present at index = element - 1
        // except for the missing and duplicate element

        int[] result = new int[2];
        for (int index = 0; index < array.length; index++) {
            if (array[index] != index + 1) {
                result[0] = array[index];
                result[1] = index + 1;
            }
        }

        return result;
    }

    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }
}
