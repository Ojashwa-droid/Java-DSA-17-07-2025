package com.ojas.dsa.sorting.problems;

// 268 leetcode
public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {2, 1, 3};
        System.out.println(missingNumber(array));

    }

    public static int missingNumber(int[] array){
        int i = 0;
        while (i < array.length){
            int correctIndex = array[i];
            if (array[i] < array.length && array[i] != array[correctIndex]){
                // swap the element with the correct index
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }

        // Now that the array has been sorted, search for the first missing number
        // Case 1:
        for (int index = 0; index < array.length; index++) {
            if (array[index] != index){
                return index;
            }
        }
        // Case 2: When the missing number is N, return N
        // cause, the sorted array in this case will be sth like [0, 1, 2, 3, 4...N-1] for [0, N]
        // and we won't be able to find the result in that case
        return array.length;
    }
    public static void swap(int[] array, int indexF, int indexS) {
        int temp = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = temp;
    }
}