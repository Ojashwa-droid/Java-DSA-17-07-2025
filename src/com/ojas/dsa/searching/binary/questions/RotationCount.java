package com.ojas.dsa.searching.binary.questions;

public class RotationCount {
    public static void main(String[] args) {
//        int[] array = {15, 18, 2, 3, 6, 12};
//        int[] array = {3, 5, 1};
        int[] array = {4,5,6,7,0,1,2};
        int i = RotationCount.countRotation(array);
        System.out.println(i);

    }

    static int countRotation(int[] array) {
        int pivot = RotationCount.findPivot(array);
        return pivot + 1;
    }

    static int findPivot(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] > array[mid + 1]) {
                // you are at the pivot element
                return mid;
            }
            if (array[mid] < array[mid - 1]) {
                // You are just next to the pivot element
                return mid - 1;
            }
            if (array[start] >= array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
