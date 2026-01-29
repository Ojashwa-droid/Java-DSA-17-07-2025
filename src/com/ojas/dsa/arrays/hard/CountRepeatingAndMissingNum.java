package com.ojas.dsa.arrays.hard;

import java.util.Arrays;

public class CountRepeatingAndMissingNum {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 1, 1};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(arr)));
    }

    public static int[] findMissingAndRepeatedValues(int[] arr) {
        int n = arr.length;
        int XORNum = 0;
        for (int i = 0; i < n; i++) {
            XORNum ^= arr[i];
            XORNum ^= (i + 1);
        }

        int bitNo = 0;
        while (true){
            if ((XORNum & (1 << bitNo)) != 0){
                break;
            }
            bitNo++;
        }

        int zeroGroup = 0;
        int oneGroup = 0;

        // For the given array
        for (int i = 0; i < n; i++) {
            // Part of oneGroup
            if ((arr[i] & (1<<bitNo)) != 0){
                oneGroup ^= arr[i];
            }

            // zeroGroup
            else {
                zeroGroup ^= arr[i];
            }
        }

        // For the n-Numbers
        for (int i = 1; i <= n; i++) {
            // Part of oneGroup
            if ((i & (1<<bitNo)) != 0){
                oneGroup ^= i;
            }

            // zeroGroup
            else {
                zeroGroup ^= i;
            }
        }

        int count = 0;
        for (int num: arr){
            if (num == zeroGroup){
                count++;
            }
        }

        if (count == 2) return new int[] {zeroGroup, oneGroup};
        return new int[] {oneGroup, zeroGroup};
    }
}
