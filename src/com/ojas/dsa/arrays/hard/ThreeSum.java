package com.ojas.dsa.arrays.hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumV2(nums));
    }

    public static List<List<Integer>> threeSumV2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;


        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumValue = -(nums[i] + nums[j]);
                if (hashSet.contains(sumValue)){
                    // To get the 3 elements (triplets) into a list form
                    List<Integer> tempList = new ArrayList<>();
                    tempList.addAll(List.of(nums[i], nums[j], sumValue));

                    // Sort them in order to ensure the uniqueness in the result Set
                    // and add them to a set, for unique triplets
                    Collections.sort(tempList);
                    result.add(tempList);

                    // At the end, add the element at jth index to the hashSet
                    hashSet.add(nums[j]);
                } else {
                    hashSet.add(nums[j]);
                }
            }
            hashSet.removeAll(hashSet);
        }

        return result.stream().toList();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.addAll(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(tempList);
                        result.add(tempList);
                    }
                }
            }
        }
        return result.stream().toList();
    }
}