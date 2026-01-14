package com.ojas.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsWithoutEqualPosNeg {
    public static void main(String[] args) {
        int[] nums = {1, -4, -2, 5, 3, 6};
        System.out.println(Arrays.toString(rearrangeArray(nums)));

    }

    public static int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) negative.add(nums[i]);
            else positive.add(nums[i]);
        }

        int length = Math.min(positive.size(), negative.size());

        int i;
        for (i = 0; i < length; i++) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }

        int index = 2 * length;
        while (i < positive.size()) {
            nums[index] = positive.get(i);
            index++;
            i++;
        }
        while (i < negative.size()) {
            nums[index] = negative.get(i);
            index++;
            i++;
        }

        return nums;
    }
}