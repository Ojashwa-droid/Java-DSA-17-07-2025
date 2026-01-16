package com.ojas.dsa.arrays.easy;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] firstHalf = new int[n];
        int[] secondHalf = new int[n];

        for(int i = 0; i < n; i++){
            firstHalf[i] = nums[i];
        }

        int index = 0;
        for (int i = n; i < 2 * n; i++){
            secondHalf[index++] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[2 * i] = firstHalf[i];
            nums[2 * i + 1] = secondHalf[i];
        }
        return nums;
    }
}
