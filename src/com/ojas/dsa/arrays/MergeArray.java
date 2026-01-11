package com.ojas.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 2};
//        merge(nums1, 9, nums2, 3);

        mergeV2(nums1, 6, nums2, 3);

    }


    // Optimal Approach
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }

        while (i >= 0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(nums1));

    }


    // Brute force approach
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < m - n && j < n) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else if (nums2[j] < nums1[i]) {
                list.add(nums2[j]);
                j++;
            } else {
                list.add(nums1[i]);
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        while (i < m && nums1[i] != 0) {
            list.add(nums1[i]);
            i++;
        }

        while (j < n) {
            list.add(nums2[j]);
            j++;
        }

        int index = 0;
        for (int element : list) {
            nums1[index++] = element;
        }

        System.out.println(Arrays.toString(nums1));
    }
}
