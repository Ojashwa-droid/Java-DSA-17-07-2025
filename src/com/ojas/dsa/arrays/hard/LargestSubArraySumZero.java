package com.ojas.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArraySumZero {
    public static void main(String[] args) {
//        int[] nums = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        int[] nums = {1, 0, -4, 3, 1};
        System.out.println(largestSubArraySumZeroV1(nums));
    }


    public static int largestSubArraySumZeroV1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            if (prefixSum == 0) {
                maxLength = i + 1;
            } else {
                if (map.containsKey(prefixSum - 0)) {
                    maxLength = Math.max(maxLength, i - map.get(prefixSum));
                } else {
                    map.put(prefixSum, i);
                }
            }
        }
        return maxLength;
    }

    public static int largestSubArraySumZeroV2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        int prefixSum = 0;

        map.put(0, 0);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - 0)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}