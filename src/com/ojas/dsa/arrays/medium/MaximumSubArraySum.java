package com.ojas.dsa.arrays.medium;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-1, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int start = Integer.MIN_VALUE;
        int sumStart = -1;
        int sumEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                sumStart = start;
                sumEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.print("[");
        for (int i = sumStart; i <= sumEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        return maxSum;
    }
}
