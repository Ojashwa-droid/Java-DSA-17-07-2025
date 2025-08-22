package com.ojas.dsa.sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Google Interview Question
public class DisappearingNumber {
    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        System.out.println(disappearingNumbers(array));

    }

    public static List<Integer> disappearingNumbers(int[] array){
        // First use cycle sort to sort the array with index = value - 1
        // range of array -> [1, N]

        int i = 0;
        while (i < array.length){
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }
        // Now the array will be sorted with elements in their respective positions
        // except for the missing elements
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < array.length; index++) {
            if (array[index] != index + 1){
                result.add(index + 1);
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
