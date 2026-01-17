package com.ojas.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2};
        System.out.println(longestConsecutiveV2(nums));

    }

    public static int longestConsecutiveV2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int maxLength = 0;

        Set<Integer> integerSet = new HashSet<>();

        for (int element : nums) {
            integerSet.add(element);
        }

        for (int element : integerSet) {
            if (!integerSet.contains(element - 1)){
                int count = 1;
                while (integerSet.contains(element + 1)){
                    element += 1;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int longest = 0;
        int currentCount = 0;
        int prevSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == prevSmaller) {
                currentCount++;
                prevSmaller = nums[i];
            } else if (nums[i] != prevSmaller) {
                currentCount = 1;
                prevSmaller = nums[i];
            }
            longest = Math.max(longest, currentCount);
        }
        return longest;
    }
}
