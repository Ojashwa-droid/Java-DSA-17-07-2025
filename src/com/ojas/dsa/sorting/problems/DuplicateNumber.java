package com.ojas.dsa.sorting.problems;


// Amazon Question
// https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] array = {1,3,4,2,2};
        System.out.println(findDuplicate(array));
    }

    public static int findDuplicate(int[] array) {
        // First sort the array using cyclic sort
        // Range: [1, N]
        int i = 0;
        while (i  < array.length){
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }
        // Now that the array is sorted, we can simply iterate over the array
        // the element which is not equal to index + 1 is the duplicate element
        int result = -1;
        for (int index = 0; index < array.length; index++) {
            if (array[index] != index + 1){
                result = array[index];
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
