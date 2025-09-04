package com.ojas.dsa.sorting.problems;

import java.util.Arrays;


// Pending

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return nums1;
        }
        for (int i = 0, j = 0; i < m; ) {
            if (nums1[i] > nums2[j]) {
                // swap the numbers such that nums1 has the smaller number
                swap(nums1, nums2, i, j);
            } else if (nums1[i] <= nums2[j]) {
                i++;
            }
        }

        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        return nums1;
    }

    public static void swap(int[] array1, int[] array2, int indexOfFirstArray, int indexOfSecondArray) {
        int temp = array1[indexOfFirstArray];
        array1[indexOfFirstArray] = array2[indexOfSecondArray];
        array2[indexOfSecondArray] = temp;
    }
}
