package com.ojas.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }


    // Using Hashmap -> optimal approach
    public static int[] twoSumV2(int[] arr, int target){
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i ++){
            int need = target - arr[i];

            if (seen.containsKey(need)) {
                return new int[]{i, seen.get(need)};
            }
            seen.put(arr[i], i);
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        // arr -> [2,7,11,15]
        // Now the array is sorted

        int left = 0;
        int right = arr.length - 1;

        int[] result = new int[2];

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                int numOne = arr[left];
                int numTwo = arr[right];

                result[0] = findIndex(copyArray, numOne, -1);
                result[1] = findIndex(copyArray, numTwo, result[0]);
                return result;
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    private static int findIndex(int[] copyArray, int numToFind, int indexToSkip) {
        for (int i = 0; i < copyArray.length; i++) {
            if (copyArray[i] == numToFind && i != indexToSkip) {
                return i;
            }
        }
        return -1;
    }
}
