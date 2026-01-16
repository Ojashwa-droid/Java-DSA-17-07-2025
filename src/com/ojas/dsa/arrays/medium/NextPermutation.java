package com.ojas.dsa.arrays.medium;

import java.util.Arrays;


public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 0, 0};
        nextPermutationV2(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void nextPermutationV2(int[] nums) {
        int n = nums.length;
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            // Finding the pivot or the break
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Finding the next larger number than the number at 'index'
        for (int i = n - 1; i >= index + 1; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        // Reverse the portion of array right to the 'index', to sort that part in ascending order
        reverse(nums, index + 1, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }
}
