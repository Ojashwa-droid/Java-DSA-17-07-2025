package com.ojas.dsa.searching.binary.algo;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] array = {-24, -12, 2, 4, 6, 9, 11, 14, 20, 36, 79};
        int[] array = {24, 12, -2, -4, -6, -9, -11, -14, -20, -36, -79};
        int target = 2;
        int search = OrderAgnosticBinarySearch.orderAgnosticBinarySearch(array, target);
        System.out.println(search);
    }

    public static int orderAgnosticBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        // Find whether the array is sorted in ascending or descending order
        boolean isAscending = array[start] < array[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == array[mid])
                return mid;

            if (isAscending) {
                if (target > array[mid])
                    start = mid + 1;
                else if (target < array[mid])
                    end = mid - 1;
            } else {
                if (target > array[mid])
                    end = mid - 1;
                else if (target < array[mid])
                    start = mid + 1;
            }

        }

        // If the item is not in the array the return -1.
        return -1;
    }
}