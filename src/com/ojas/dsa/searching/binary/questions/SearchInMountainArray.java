package com.ojas.dsa.searching.binary.questions;

public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] array = {-4, -1, 1, 2, 4, 5, 3, 1, 0, -13};
        int target = 3;
        int inMountainArray = findInMountainArray(array, target);
        System.out.println(inMountainArray);

    }

    public static int findInMountainArray(int[] array, int target) {
        // 1. Find the peak index of the mountain array
        int peakElementIndex = findPeakElement(array);

        // 2. Search in the left half of the array else search in the right half of the array
        int result = orderAgnosticBinarySearch(array, target, 0, peakElementIndex);
        if (result != -1) {
            return result;
        } else {
            return orderAgnosticBinarySearch(array, target, peakElementIndex + 1, array.length - 1);
        }
    }

    // Finding the peak index of the mountain array
    public static int findPeakElement(int[] array) {
        // since this is a sorted array
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] > array[mid + 1]) {
                // we are in the decreasing part of the array
                end = mid; // this could be a possible answer
            } else {
                // you are in the increasing part of the array
                start = mid + 1;
            }
        }
        return start;
    }

    // OrderAgnostic Binary search in a given range (start and end are given)
    public static int orderAgnosticBinarySearch(int[] array, int target, int start, int end) {
        boolean isAscending = array[start] < array[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == array[mid])
                return mid;

            if (isAscending) {
                if (target > array[mid]) {
                    start = mid + 1;
                } else if (target < array[mid]) {
                    end = mid - 1;
                }
            } else {
                if (target > array[mid])
                    end = mid - 1;
                else if (target < array[mid])
                    start = mid + 1;
            }
        }
        return -1;
    }

}
