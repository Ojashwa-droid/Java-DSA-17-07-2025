package com.ojas.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(countInversePairs(arr));
    }

    public static int countInversePairs(int[] arr) {
        int count = mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    // Main function that sorts arr[low...high] using merge()
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
        int left = low;
        int right = mid + 1;
        List<Integer> tempList = new ArrayList<>();

        int count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempList.add(arr[left]);
                left++;
            }
            // Right is smaller
            else {
                count += (mid - left + 1);
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
}
