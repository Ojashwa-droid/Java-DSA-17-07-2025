package com.ojas.dsa.searching.linear;

// LeetCode problem no 1295: Given an array of integers, return how many of them contain an even number of digits.

public class EvenNumberOfDigits {
    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, -7894, 0};
        int result = EvenNumberOfDigits.findNumbers(nums);
        System.out.println(result);
    }

    private static int findNumbers(int[] nums) {

        if (nums.length == 0)
            return 0;

        // Initially zero no of numbers with even no digit
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (hasEvenDigits(number))
                count++;
        }

        return count;
    }

    private static boolean hasEvenDigits(int number) {
        int digits = 0;

        if (number < 0)
            number *= -1;

        if (number == 0)
            digits = 1;

        while (number > 0) {
            digits++;
            number = number / 10;
        }
        return digits % 2 == 0;
    }
}
