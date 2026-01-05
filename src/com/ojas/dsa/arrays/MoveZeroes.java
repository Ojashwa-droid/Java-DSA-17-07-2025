package com.ojas.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        moveZeroesV2(nums);
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] integers = new int[n];

        int i = 0;
        for (int element : nums) {
            // If an element is zero, skip it and add just the non-zero elements to the array
            if (element != 0) {
                integers[i] = element;
                i++;
            }
        }

        if (integers[0] == 0) {
            return;
        }

        // Now the integer list contains the non-zero elements in relative order
        int index = 0;
        for (int element : integers) {
            nums[index] = element;
            index++;
        }

        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    // Optimal approach
    public static void moveZeroesV2(int[] nums) {
        // Two indices : one for iteration and one for finding the non-zero elements

        int left = 0;
        int right = 0;
        int n = nums.length;

        while (right < n) {
            if ((nums[left] == 0) && (nums[right] != 0)){
                swap(nums, left, right);
                left++;
                right++;
            } else if(nums[left] != 0 && nums[right] == 0){
                left = right;
            } else {
                right++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
