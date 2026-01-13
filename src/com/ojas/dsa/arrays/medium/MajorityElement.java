package com.ojas.dsa.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 1, 2, 2};
        int[] nums2 = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementV2(nums2));

    }

    // Moore's Voting Algorithm
    public static int majorityElementV2(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // Now we have our candidate element, according to the Moore's algorithm

        int candidateElementCount = 0;
        for (int element : nums) {
            if (element == candidate) {
                candidateElementCount++;
            }
        }

        if (candidateElementCount > (nums.length / 2)) {
            return candidate;
        }
        return -1;
    }


    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int element : nums) {
            if (hashMap.containsKey(element)) {
                int oldFreq = hashMap.get(element);
                hashMap.put(element, oldFreq + 1);
            } else {
                hashMap.put(element, 1);
            }
        }

        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) > (n / 2)) {
                return key;
            }
        }

        return -1;
    }
}
