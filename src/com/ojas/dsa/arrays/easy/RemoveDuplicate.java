package com.ojas.dsa.arrays.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1,1,2,2,2,3,3};
        int result = RemoveDuplicate.removeDuplicateV3(nums);
        System.out.println(result);

    }

    public static int removeDuplicates(int[] nums) {

        // nums = [0,0,1,1,1,2,2,3,3,4]

        Set<Integer> integerSet = new TreeSet<>();
        for (int element : nums) {
            integerSet.add(element);
        }

        // Now the set contains the unique elements
        for (int i = 0; i < nums.length - 1; i++) {
            if (integerSet.iterator().hasNext()) {
                nums[i] = integerSet.iterator().next();
            }
        }
        System.out.println(Arrays.toString(nums));
        return integerSet.size();
    }

    public static int removeDuplicateV2(int[] nums) {

        // nums = {1,1,2,2,2,3,3};

        int index1 = 0;
        int index2 = 0;

        int[] uniqueElements = new int[nums.length];
        int i = 0;
        while (index2 <= nums.length - 1){
            if (index1 == index2){
                uniqueElements[i] = nums[index1];
                index2++;
                i++;
            } else if (nums[index2] == nums[index1]) {
                index2++;
            } else {
                index1 = index2;
            }
        }

        int j = 0;
        for (int element : uniqueElements){
            nums[j] = element;
            j++;
        }
        return i + 1;
    }

    public static int removeDuplicateV3(int[] nums) {

        // nums = {1,1,2,2,2,3,3};

        int index1 = 0;
        int index2 = 1;

        while (index2 <= nums.length - 1){
            // Case 1: If the value on both the indices are same
            // do nothing just increment the 2nd index
            if (nums[index2] == nums[index1]){
                index2++;
            } else {
                index1++;
                nums[index1] = nums[index2];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index1 + 1;
    }
}
