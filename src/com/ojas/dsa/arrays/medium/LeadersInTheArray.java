package com.ojas.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersInTheArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        System.out.println(Arrays.toString(findLeadersV2(arr)));
    }

    public static int[] findLeadersV2(int[] arr) {
        int n = arr.length;
        int prevLeader = arr[n - 1];

        List<Integer> list = new ArrayList<>();
        list.add(prevLeader);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > prevLeader) {
                prevLeader = arr[i];
                list.add(arr[i]);
            }
        }

        int index = 0;
        int[] leaders = new int[list.size()];
        for (int element : list) {
            leaders[index++] = element;
        }
        return leaders;
    }

    public static int[] findLeadersV1(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // For each element, find the max from (i + 1) to n - 1
            int max = findMax(arr, i + 1);
            if (arr[i] > max) {
                // current element is a leader
                list.add(arr[i]);
            }
        }
        list.add(arr[n - 1]);

        int index = 0;
        int[] leaders = new int[list.size()];
        for (int element : list) {
            leaders[index++] = element;
        }
        return leaders;
    }

    private static int findMax(int[] arr, int index) {
        int max = Integer.MIN_VALUE;
        for (int i = index; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}