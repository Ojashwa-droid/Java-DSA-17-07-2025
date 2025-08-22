package com.ojas.dsa.sorting.problems;

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicates {

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(array));
    }

    public static List<Integer> findDuplicates(int[] nums) {
         int i = 0;
        while (i < nums.length) {
            // is value on ith index at the correct postion?
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        // The array is sorted , now we can find the duplicates
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1){
                list.add(nums[index]);
            }
        }


        return list;
    }
    public static void swap(int[] arr, int first, int second) {
       int temp = arr[first];
       arr[first] = arr[second];
       arr[second] = temp;
    }
}