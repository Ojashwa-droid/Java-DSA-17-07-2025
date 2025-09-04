package com.ojas.dsa.searching.binary.questions;

public class SmallestDivisorForThreshold {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] array, int threshold) {
        // Finding out the range - Range: [1, max(array)]
        // If the divisor is 1, the sum will be equal to the sum of the elements of the array & > threshold
        // If the divisor is max(array), the sum will be equal to the size of the array & <= threshold
        // But, we are in search of the smallest divisor such that sum <= threshold

        int start = 1;
        int end = Integer.MIN_VALUE;
        for (int element : array) {
            end = Math.max(element, end);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sumForCurrentDivisor(array, mid) <= threshold) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int sumForCurrentDivisor(int[] array, int divisor) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += (array[i] + divisor - 1) / divisor;
        }
        return sum;
    }
}