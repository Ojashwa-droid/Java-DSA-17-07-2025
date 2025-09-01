package com.ojas.dsa.sorting.problems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));

    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (i < nums1.length){
            // if element at the 'i' pointer in nums1 is smaller or equal to element at 'j' in nums2
            if (nums1[i] != 0 && nums1[i] <= nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]) {
                // swap the two elements
                swap(nums1 ,nums2, i, j);
            } else {
                nums1[i] = nums2[j];
                j++;
            }
        }
        return nums1;
    }
    public static void swap(int[] array1, int[] array2, int firstIndex, int secondIndex){
        int temp = array1[firstIndex];
        array1[firstIndex] = array2[secondIndex];
        array2[secondIndex] = temp;
     }
}
