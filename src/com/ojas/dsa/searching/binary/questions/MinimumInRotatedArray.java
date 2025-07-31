package com.ojas.dsa.searching.binary.questions;

public class MinimumInRotatedArray {
    public static void main(String[] args) {
//        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(MinimumInRotatedArray.finMin(array));

    }

    public static int finMin(int[] array) {
        // In case the array is not rotated or the array is of length 1
        if (array[0] < array[array.length - 1])
            return array[0];

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && array[mid] > array[mid + 1]) {
                return array[mid + 1]; // The element next to the pivot will be the smallest element as the array is sorted.
            }

            if (mid > start && array[mid] < array[mid - 1]) {
                return array[mid]; // Again, the element next to pivot is our ans
            } else if (array[start] > array[mid]) {
                // We can ignore the elements after mid as there won't be a pivot after mid as the array is sorted
                end = mid - 1;
            } else if (array[start] < array[mid]) {
                start = mid + 1; // No pivot before mid -> array is sorted
            }
        }

        return array[0];
    }

}
