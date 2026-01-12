package com.ojas.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortColours {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1, 1, 0};
//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));
        sortColorsV2(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sortColorsV2(int[] arr){
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int element: arr){
            if (element == 0){
                countZero++;
            } else if (element == 1) {
                countOne++;
            } else {
                countTwo++;
            }
        }


        for (int i = 0; i < arr.length; i++){
            if (countZero > 0){
                arr[i] = 0;
                countZero--;
            } else if (countOne > 0){
                arr[i] = 1;
                countOne--;
            } else {
                arr[i] = 2;
            }
        }
    }


    public static void sortColors(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int element : nums) {
            if (seen.containsKey(element)) {
                int oldFreq = seen.get(element);
                seen.put(element, oldFreq + 1);
            } else {
                seen.put(element, 1);
            }
        }

        int lastIndex = 0;
        for (int i = 0; i <= 2; i++) {
            int count = seen.get(i);
            lastIndex = fillColors(nums, count, i, lastIndex);
        }
    }

    private static int fillColors(int[] nums, int count, int colourToFill, int lastIndex) {
        int i;
        for (i = lastIndex; i < lastIndex + count; i++) {
            nums[i] = colourToFill;
        }
        return i;
    }
}
