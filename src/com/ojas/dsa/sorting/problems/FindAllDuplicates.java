package com.ojas.dsa.sorting.problems;

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicates {

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(array));
    }

    public static List<Integer> findDuplicates(int[] array) {
         int i = 0;
        while (i < array.length) {
            // is value on ith index at the correct position?
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]) {
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }
        // The array is sorted , now we can find the duplicates
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < array.length; index++) {
            if (array[index] != index + 1){
                list.add(array[index]);
            }
        }
        return list;
    }
    public static void swap(int[] arr, int first, int second) {
       int temp = arr[first];
       arr[first] = arr[second];
       arr[second] = temp;
    }
}