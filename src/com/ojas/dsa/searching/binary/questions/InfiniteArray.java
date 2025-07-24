package com.ojas.dsa.searching.binary.questions;

// Amazon Interview Ques
public class InfiniteArray {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        int result = ans(array, target);
        System.out.println(result);
    }

    private static int ans(int[] array, int target) {
        // First find the range

        // start with the box of size 2
        int start = 0;
        int end = 1;


        while (target > array[end]) {
            int temp = end + 1; // this is my new start
            // double the size of the chunk
            // end = previousEnd + previousSize * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(array, target, start, end);
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            // Find the middle index to compare the values from
            int mid = start + (end - start) / 2;

            if (target > array[mid]) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                // Answer found
                return mid;
            }
        }
        return -1;
    }
}
