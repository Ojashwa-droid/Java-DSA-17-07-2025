package com.ojas.dsa.searching.binary.questions;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int result = SplitArrayLargestSum.splitArray(nums, m);
        System.out.println(result);
    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // In the end of the loop this will contain max element of the array
            end += nums[i];
        }

        // Binary search in this start and end (our potential answers)
        while (start < end) {
            // Try for the middle as the potential ans
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this array with largest sum
            int sum = 0;
            int pieces = 1;
            for (int num: nums){
                if (sum + num > mid){
                    // you cannot add this in this sub-array, make a new one
                    // say that you add this num in new sub-array, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces <= m){ // meaning we have the largest sum greater than the ans --> as the number of sub-array are lesser that given m
                end = mid;
            } else if (pieces > m) {
                start = mid + 1;
            }
        }

        return start; // here start == end
    }
}
