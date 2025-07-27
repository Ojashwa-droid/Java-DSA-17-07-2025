package com.ojas.dsa.searching.binary.questions;

public class RotatedBinarySearchWithDuplicates {
    public static void main(String[] args) {

    }

    static int findPivotWithDuplicates(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases that we had discussed

            if (mid < end && array[mid] > array[mid + 1]) {
                // We are at the pivot
                return mid;
            } else if (mid > start && array[mid] < array[mid - 1]) {
                // We are at the pivot
                return mid - 1;
            }

            if (array[start] == array[mid] && array[mid] == array[end]) {
                // Skip the duplicates
                // Note: what if the elements at the start and end are the pivots
                // so check if they are pivot before skipping them
                if (array[start] > array[start + 1]){
                    return start;
                }
                start++;
                if (array[end] < array[end - 1]){
                    return end - 1;
                }
                end--;
            } else if (array[start] < array[mid] || array[start] == array[mid] && array[mid] > array[end]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    static int pivotBS(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target)
                return mid;
            else if (target > array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
