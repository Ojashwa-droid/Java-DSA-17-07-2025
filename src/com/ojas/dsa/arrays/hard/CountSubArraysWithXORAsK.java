package com.ojas.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithXORAsK {
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        System.out.println(countSubArrays(nums, 6));

    }

    public static int countSubArrays(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;

        // Make an entry of currentXOR as '0' with its frequency as '1'.
        // In order to count the first XOR within the total count.
        hashMap.put(0, 1);

        int currentXOR = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            currentXOR ^= nums[i];

            if (hashMap.containsKey(currentXOR ^ k)) {
                count += hashMap.get(currentXOR ^ k);
            }

            hashMap.put(currentXOR, hashMap.getOrDefault(currentXOR, 0) + 1);
        }
        return count;
    }
}
