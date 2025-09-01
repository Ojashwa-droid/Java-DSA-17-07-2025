package com.ojas.dsa.searching.binary.questions;

public class BouquetInMinDays {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] array, int m, int k) {
        // The scenario where it is impossible to form 'm' bouquets
        // i.e. when we don't have enough flowers

        long value = (long) m * k;
        if (value > array.length) {
            return -1;
        }

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int element : array) {
            start = Math.min(start, element);
            end = Math.max(end, element);
        }

        // So our range is from the min day to the max day, and we are reducing the search space
        // by looking at the possibility of forming m bouquets
        while (start <= end) {
            int mid = start + (end - start) / 2;


            // If it's possible to make m bouquets at the current day,
            // it might also be possible that a smaller solution exists on the right of the current day
            if (possible(array, mid, m, k)) {
                end = mid - 1;
            } else {

                // If it's not possible to make bouquet on the current day,
                // then surely it's not possible to make the bouquet in days left of the current day
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean possible(int[] array, int day, int m, int k) {

        int count = 0;
        int noOfBouquets = 0;

        for (int bloomDayOfCurrentFlower : array) {
            if (bloomDayOfCurrentFlower <= day) {
                count++;
            } else {
                noOfBouquets += (count / k);
                count = 0;
            }
        }
        noOfBouquets += (count / k);
        return noOfBouquets >= m;
    }
}
