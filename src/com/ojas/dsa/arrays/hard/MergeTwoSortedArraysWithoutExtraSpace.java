package com.ojas.dsa.arrays.hard;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        List<int[]> merged = mergeV2(arr1, 4, arr2, 5);
        for (int[] element : merged) {
            System.out.println(Arrays.toString(element));
        }

    }

    public static List<int[]> mergeV2(int[] arr1, int n, int[] arr2, int m) {
        int length = m + n;
        int gap = (length / 2) + (length % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < length){

                // arr1 & arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }

                // arr2 & arr2
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }

                // arr1 & arr1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }

                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
        return List.of(arr1, arr2);
    }

    public static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2){
        if (arr1[index1] > arr2[index2]) {
            swapArrElements(arr1, index1, arr2, index2);
        }
    }
    public static List<int[]> merge(int[] arr1, int n, int[] arr2, int m) {
        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                // That means, the current element of arr1 should be in arr2
                swapArrElements(arr1, left, arr2, right);
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return List.of(arr1, arr2);
    }

    public static void swapArrElements(int[] arr1, int index1, int[] arr2, int index2) {
        int temp = arr2[index2];
        arr2[index2] = arr1[index1];
        arr1[index1] = temp;
    }
}
