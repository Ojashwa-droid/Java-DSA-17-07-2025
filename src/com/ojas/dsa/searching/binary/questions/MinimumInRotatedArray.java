package com.ojas.dsa.searching.binary.questions;

public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 2, 3};
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(MinimumInRotatedArray.finMin2(array));

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

    // Second approach

    public static int finMin2(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Find the sorted half
            if (array[start] <= array[mid]) {
                // Sorted half found
                // It may or may not contain the ans
                if (array[start] < ans) {
                    ans = array[start];
                }
                start = mid + 1;
            }

            if (array[mid] <= array[end]) {
                // Right half is sorted
                // May or may not contain the ans
                if (array[mid] < ans) {
                    ans = array[mid];
                }
                end = mid - 1;
            }
        }
        return ans;
    }


}
