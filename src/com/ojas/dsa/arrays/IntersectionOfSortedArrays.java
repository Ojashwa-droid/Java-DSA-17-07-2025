package com.ojas.dsa.arrays;

import java.util.*;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 3, 5, 6, 7};
        int[] intersectionV1 = findIntersectionV1(arr1, arr2);
        System.out.println(Arrays.toString(intersectionV1));

        int[] intersectionV2 = findIntersectionV2(arr1, arr2);
        System.out.println(Arrays.toString(intersectionV2));

    }

    public static int[] findIntersectionV2(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < n1 && j < n2){
            if (arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] intersection = new int[list.size()];
        int index = 0;
        for (int element: list){
            intersection[index++] = element;
        }
        return intersection;
    }

    public static int[] findIntersectionV1(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] visited = new int[n2];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0){
                    list.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }

                if (arr2[j] > arr1[i]) {
                    break;
                }
            }
        }

        int[] intersection = new int[list.size()];
        int index = 0;
        for (int element: list){
            intersection[index++] = element;
        }
        return intersection;
    }
}
