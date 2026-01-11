package com.ojas.dsa.arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));

    }

    // Using XOR operator
    public static int missingNumber(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }

        if (max != arr.length){
            return arr.length;
        }

        int XOR = 0;
        for (int i = 0; i <= max; i++) {
            XOR ^= i;
        }

        for (int element : arr) {
            XOR ^= element;
        }
        return XOR;
    }
}
