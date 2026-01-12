package com.ojas.dsa.arrays.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
        rotateArrayV2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    // Brute Force Approach
    public static void rotateArray(int[] nums, int k) {
        // 'K' denotes the number of steps the array needs to be rotated in right direction
        // [1,2,3,4,5,6,7] -> [5,6,7,1,2,3,4]

        // Create a new array of size k, to store the numbers that need to be put in the starting of the array


        int n = nums.length;


//        if (n == 0 || n == 1) return;
        k = k % n;

        int[] array = new int[k];
        int index = 0;
        for (int i = n - k; i < n; i++) {
            array[index] = nums[i];
            index++;
        }
        System.out.print("K size array: ");
        System.out.println(Arrays.toString(array));

        for (int i =  n - k - 1; i >= 0 ; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = array[i];
        }

        System.out.print("Rotated array: ");
        System.out.println(Arrays.toString(nums));

    }


    // Optimal approach
    public static void rotateArrayV2 (int[] nums, int k){
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int startingIndex, int endingIndex) {
        int temp = Integer.MAX_VALUE;

        while (startingIndex < endingIndex){
            temp = nums[endingIndex];
            nums[endingIndex] = nums[startingIndex];
            nums[startingIndex] = temp;
            startingIndex++;
            endingIndex--;
        }
    }
}
