package com.ojas.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountReverse {
    public static void main(String[] args) {
        int[] nums = {40, 25, 19, 12, 9, 6, 2};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        int count = mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            // Find the middle point
            int mid = low + (high - low) / 2;

            // Sort first and second halves
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);

            // Merge the sorted halves
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        // Step 1: Counting the number of reverse pairs
        int count = countPairs(arr, low, mid, high);


        // Step 2: Merging the two parts of the array
        int left = low;
        int right = mid + 1;
        List<Integer> tempList = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempList.add(arr[left]);
                left++;
            }
            // Right is smaller
            else {
                tempList.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            tempList.add(arr[left]);
            left++;
        }
        while (right <= high) {
            tempList.add(arr[right]);
            right++;
        }

        // Transferring the elements from the sorted list to the arr
        for (int i = low; i <= high; i++) {
            arr[i] = tempList.get(i - low);
        }
        return count;
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int count = 0;

        while (left <= mid && right <= high) {
            // Can be a pair
            // arr[i] > 2 * arr[j]

            if (arr[left] > 2 * arr[right]) {
                count += (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return count;
    }
}
