package com.ojas.dsa.searching.binary;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] array = {-24, -12, 2, 4, 6, 9, 11, 14, 20, 36, 79};
        int target = 36;
        int result = BinarySearchAlgo.binarySearch(array, target);
        System.out.println(result);
    }

    // Return the index of the item
    private static int binarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // Find the middle element
            //  int mid = (start + end) / 2; // There might be a possibility that (start + end) exceeds the int size --> throw in accurate value or give error
            int mid = start + (end - start) / 2;

            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        // If the item is not found in the array -> returns -1
        return -1;
    }

}
