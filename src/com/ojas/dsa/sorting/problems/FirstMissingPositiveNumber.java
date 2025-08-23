package com.ojas.dsa.sorting.problems;

public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(firstMissingPositive(array));

    }

    public static int firstMissingPositive(int[] array) {
        // First simply sort it using cyclic sort, by keeping following two points in mind
        // 1. The element should be > 0 (cause the index for element 0 will be -1, which doesn't exist)
        // 2. The element should be <= N (no possible index for element greater than the size of array N)
        // Lets call these numbers "right" numbers

        int i = 0;
        while (i < array.length){
            int correctIndex = array[i] - 1; // correct index for the numbers we want to sort
            if (array[i] > 0 && array[i] <= array.length && array[i] != array[correctIndex]){
                // swap
                swap(array, i , correctIndex);
            } else {
                i++;
            }
        }

        // Now that the array has been sorted with "right" numbers at their correct index
        // We can start searching for the smallest missing +ive number by searching from 1
        int index = 0;
        while(index < array.length){
            if (array[index] != index + 1){
                return index + 1;
            } else {
                index++;
            }
        }

        return array.length + 1;
    }

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
