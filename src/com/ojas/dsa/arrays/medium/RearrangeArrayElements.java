package com.ojas.dsa.arrays.medium;

import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
//        System.out.println(Arrays.toString(rearrangeArray(nums)));
        System.out.println(Arrays.toString(rearrangeArrayV2(nums)));
    }


    // Optimal approach
    public static int[] rearrangeArrayV2(int[] nums){
        int pos = 0;
        int neg = 1;
        int n = nums.length;
        int[] result = new int[n];

        for (int element: nums){
            if (element > 0){
                result[pos] = element;
                pos += 2;
            } else {
                result[neg] = element;
                neg += 2;
            }
        }
        return result;
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n / 2];
        int[] negative = new int[n / 2];

        int posIndex = 0;
        int negIndex = 0;
        for (int element : nums) {
            if (element >= 0) {
                positive[posIndex] = element;
                posIndex++;
            } else {
                negative[negIndex] = element;
                negIndex++;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = positive[i];
            nums[(2 * i) + 1] = negative[i];
        }
        return nums;
    }
}
