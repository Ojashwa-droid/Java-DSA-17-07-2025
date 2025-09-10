package com.ojas.dsa.searching.binary.questions;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stall = {2, 12, 11, 3, 26, 7};
        int cows = 5;
        System.out.println(maxOfMinDistancesInStall(stall,cows));

    }

    public static int maxOfMinDistancesInStall(int[] array, int cows) {
        // For the range: [1, (max-min)]
        Arrays.sort(array);

        int start = 0;
        int end = array[array.length - 1] - array[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Now check whether we can place the cows for this min distance or not
            if (canWePlaceTheCows(array, cows, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static boolean canWePlaceTheCows(int[] array, int cows, int distance) {
        int currentCow = 1;
        int lastPlaced = array[0]; // The previous stall where the cow was placed.

        for (int i = 1; i < array.length; i++) {
            if ((array[i] - lastPlaced) >= distance) {
                currentCow++;
                lastPlaced = array[i];
            }
        }
        return currentCow >= cows;
    }
}
