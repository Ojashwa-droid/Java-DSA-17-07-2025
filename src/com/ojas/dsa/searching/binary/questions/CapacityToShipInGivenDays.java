package com.ojas.dsa.searching.binary.questions;

class CapacityToShipInGivenDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        // Range: [max, sum]

        int start = Integer.MIN_VALUE;
        for (int weight : weights) {
            start = Math.max(weight, start);
        }

        int end = 0;
        for (int weight : weights) {
            end += weight;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (noOfDays(weights, mid) <= days) { // A possible ans
                // But smaller answer may lie on the left of mid
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int noOfDays(int[] weights, int capacity) {
        int currentLoad = 0;
        int day = 1;

        for (int i = 0; i < weights.length; i++) {
            if (currentLoad + weights[i] <= capacity) {
                currentLoad += weights[i];
            } else {
                day++;
                currentLoad = weights[i];
            }
        }
        return day;
    }
}