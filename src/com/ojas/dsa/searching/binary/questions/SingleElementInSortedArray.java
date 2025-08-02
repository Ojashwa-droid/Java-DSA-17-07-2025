package com.ojas.dsa.searching.binary.questions;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
//        int[] array = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
//        int[] array = {1, 1, 2, 2, 3, 3, 5, 5, 6, 6};
        int[] array = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleInSortedArray(array));


    }

    public static int singleInSortedArray(int[] array) {
        int n = array.length;

        if (array.length == 1) {
            return array[0];
        }

        if (array[0] != array[1]) {
            return array[0];
        }

        if (array[n - 1] != array[n - 2]) {
            return array[n - 1];
        }

        int start = 1;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // For the current element to be the single index
            if (array[mid] != array[mid + 1] && array[mid] != array[mid - 1]) {
                return array[mid]; // we found the answer
            }

            if ((mid % 2 == 1 && array[mid - 1] == array[mid]) || (mid % 2 == 0 && array[mid] == array[mid + 1])) {
                // We are in the left half (even , odd) pair exist on the left of the single element
                start = mid + 1;
            } else {
                // pair (odd, even) exist on the right side of the single occurring element
                // We are on the right half of the single element
                end = mid - 1;
            }
        }
        return -1;
    }


    /*public static int singleInSortedArray(int[] array) {

        // Starting or ending elements are the single element
        if (array[0] != array[1]) {
            return array[0];
        }
        if (array[array.length - 1] != array[array.length - 2]) {
            return array[array.length - 1];
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Condition for our target single element
            if (mid > 0 && mid < end && array[mid] != array[mid + 1] && array[mid] != array[mid - 1]) {
                // We are on the single occurring element
                return array[mid]; // ans found
            }

            // If current element is duplicate element
            if (mid < end && array[mid] == array[mid + 1]) {
                // that means mid is currently on the first occurrence of the duplicates
                if ((mid + 1) % 2 != 0) {
                    // The 2nd occurrence of the duplicate is an odd index
                    // this proves that our ans does not lie in the left side
                    start = mid + 1;
                } else {
                    // element must be on the left half
                    end = mid - 1;
                }
            } else if (mid > 0 && array[mid] == array[mid - 1]) {
                // mid is currently on the 2nd occurrence of the duplicates
                if (mid % 2 != 0) {
                    // The 2nd occurrence of the duplicate is an odd index
                    // this proves that our ans does not lie in the left side
                    start = mid + 1;
                } else {
                    // element must be on the left half
                    end = mid - 1;
                }
            }


        }
        return -1;
    }*/
}
