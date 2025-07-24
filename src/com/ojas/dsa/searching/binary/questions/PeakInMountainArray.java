package com.ojas.dsa.searching.binary.questions;

// Leetcode : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakInMountainArray {
    public static void main(String[] args) {

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // you are in the decreasing part of the array
                // this may be the answer, but look at left
                // that's why end != mid - 1
                end = mid;
            } else {
                // you are in the ascending part of the array
                start = mid + 1; // because we know that mid + 1 element is greater than mid-element
            }
        }

        // in the end both start == end and point to the maximum element
        // start and end are trying to find the max element in the above 2 checks
        // hence, when they arrive at just one element, that is the best possible answer

        // Elaboration: at every instance of time, both start and end are trying to find
        // the max element and when just one element remains (array has no duplicates)
        // it's the max element.

        return start; // return either start or end index
    }
}