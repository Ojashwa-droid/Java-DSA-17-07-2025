package com.ojas.dsa.searching.binary.questions;

import java.util.Arrays;

// Leetcode: 34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] result = FirstAndLastPosition.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] startAndEndIndex = {-1, -1};

        // Check for the first occurrence of the target
        startAndEndIndex[0] = search(nums, target, true);

        // Check for the last occurrence of the target
        startAndEndIndex[1] = search(nums, target, false);

        return startAndEndIndex;
    }

    private  static int search(int[] nums, int target, boolean findStartIndex) {

        int ans = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                // Potential answer has been found --> this may be either the first or last index of the target
                ans = mid;
                if (findStartIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }


}
