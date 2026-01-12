package com.ojas.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortColours {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1, 1, 0};
//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));
//        sortColorsV2(nums);
        sortColorsV3(nums);
        System.out.println(Arrays.toString(nums));
    }


    // Dutch National Flag Algorithm
    public static void sortColorsV3(int[] arr) {
        int left = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high){
            // Case 1: if zero at mid index
            if (arr[mid] == 0){
                swap(arr, mid, left);
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }

    public static void sortColorsV2(int[] arr) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for (int element : arr) {
            if (element == 0) {
                countZero++;
            } else if (element == 1) {
                countOne++;
            } else {
                countTwo++;
            }
        }


/*        for (int i = 0; i < arr.length; i++){
            if (countZero > 0){
                arr[i] = 0;
                countZero--;
            } else if (countOne > 0){
                arr[i] = 1;
                countOne--;
            } else {
                arr[i] = 2;
            }
}*/

        for (int i = 0; i < countZero; i++) {
            arr[i] = 0;
        }

        for (int i = countZero; i < countOne + countOne; i++) {
            arr[i] = 1;
        }

        for (int i = countOne; i < arr.length; i++) {
            arr[i] = 2;
        }

    }

}
