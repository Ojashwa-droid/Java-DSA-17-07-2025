package com.ojas.dsa.searching.binary.questions;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(eatingBananaInMinTime(piles, h));
    }

    public static int eatingBananaInMinTime(int[] array, int h) {
        // We are going to first find the range for the BS
        // since we are applying the BS in the ans, whose value lies in between [1, max(array)]
        // This will be our search range for Binary Search

        int start = 1;
        int end = maxInArray(array);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long totalTimeForCurHourlyRate = calculateTotalTimeForHourlyRate(array, mid);

            if (totalTimeForCurHourlyRate <= h){
                // This might be a possible answer, but more possible answers may lie behind it
                end = mid - 1;
            } else {
                start = mid + 1; // That means we want to increase koko's hourly eating rate
            }
        }
        return start;
    }

    static long calculateTotalTimeForHourlyRate(int[] array, int hourlyRate) {
        long totalHours = 0;  // use long to avoid overflow
        for (int pile : array) {
            totalHours += (pile + hourlyRate - 1) / hourlyRate; // ceil division
        }
        return totalHours;
    }

    private static int maxInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
