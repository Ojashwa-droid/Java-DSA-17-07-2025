package com.ojas.dsa.searching.binary.questions;

public class RotatedBinarySeearch {
    public static void main(String[] args) {
        int[] array = {3, 5, 1};
        System.out.println(findPivot(array));
        System.out.println(RotatedBinarySeearch.search(array, 3));
    }

    static int search(int[] array, int target) {
        // First find the pivot
        int pivot = findPivot(array);

        if (pivot == -1) {
            return pivotBS(array, target, 0, array.length -1);
        }

        // If pivot found ---> now we have three cases bases on the pivot and target element
        if (target == array[pivot]) {
            return pivot;
        } else if (target >= array[0]) {
            // Search space is now reduced to start till pivot, as the numbers after pivot are smaller than the start.
            return pivotBS(array, target, 0, pivot - 1);
        } else {
            // Search space is now reduced to pivot + 1 till end, as the numbers before pivot will be larger than the target.
            return pivotBS(array, target, pivot + 1, array.length - 1);
        }

      /*  // Search in the first half of the array till pivot
        int elementIndex = pivotBS(array, target, 0, pivot);
        if (elementIndex != -1)
            return elementIndex;

        return pivotBS(array, target, pivot + 1, array.length -1);*/

    }

    static int findPivot(int[] array) {
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
            } else if (array[start] >= array[mid]) {
                // Elements smaller than start lie ahead of mid , so we can ignore them as we are finding the largest element
                end = mid - 1;
            } else if (array[start] < array[mid]) {
                // We are not going to find th pivot i.e. our largest in between start and mid
                start = mid + 1; // cause if mid was the pivot it would have been caught in first two cases.
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
