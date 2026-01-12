package com.ojas.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

// For Positive numbers only
public class LongestSubArraySumPos {
    public static void main(String[] args) {
        int[] arr = {1};
        int k = 0;
//        System.out.println(findLongestSubArrayLengthV3(arr, k));
        System.out.println(findLongestSubArrayLengthV2(arr, 3));
    }

    // Optimal approach using "Sliding Window"
    // Works only for positives and zeroes in the array
    // Breaks in case a -ve is encountered in the array
    public static int findLongestSubArrayLengthV3(int[] arr, int k){
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLength = 0;

        while (right < arr.length){
            // 1. Add the current element to the sum
            sum += arr[right];

            // 2. If the sum exceeds the value k, reduce the window from left
            while (sum > k && left <= right){
                // Shrink the window from the left
                sum -= arr[left];
                left++;
            }

            if (sum == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }
        return maxLength;
    }

    // Brute Force - O(N*N)
    public static int findLongestSubArrayLength(int[] arr, int k) {
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
                if (sum > k) {
                    break;
                }
            }
        }
        return maxLength;
    }

    // Using prefix sum - #Hashing
    // Handles zeroes, positives and negatives
    public static int findLongestSubArrayLengthV2(int[] arr, int k) {
        int prefixSum = 0;
        int maxLength = 0;
        int n = arr.length;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (prefixSum == k){
                maxLength = Math.max(maxLength, i + 1);
            }

            // Hash the prefix sum with its sum as the key and the index of the array as the value
            // If the prefixSum wasn't there in the hashmap
            // In case of Zeroes in the array
            if (!hashMap.containsKey(prefixSum)){
                hashMap.put(prefixSum, i);
            }

            // x -> x - (x - k)
            if (hashMap.containsKey(prefixSum - k)){
                maxLength = Math.max(maxLength, i - hashMap.get(prefixSum - k));
            }
        }
        return maxLength;
    }
}
