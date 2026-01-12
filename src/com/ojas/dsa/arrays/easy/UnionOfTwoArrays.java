package com.ojas.dsa.arrays.easy;

import java.util.*;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5, 6};
//        int[] union = UnionOfTwoArrays.findUnionV1(arr1, arr2);
//        System.out.println(Arrays.toString(union));
        int[] unionV2 = findUnionV2(arr1, arr2);
        System.out.println(Arrays.toString(unionV2));

    }


    // Optimal Approach
    public static int[] findUnionV2(int[] arr1, int[] arr2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> result = new ArrayList<>();

        while (pointer2 < n2 && pointer1 < n1) {
            int num1 = arr1[pointer1];
            int num2 = arr2[pointer2];
            if (num1 <= num2) {
                if (!result.contains(num1)) {
                    result.add(num1);
                }
                pointer1++;
            } else  {
                if (!result.contains(num2)) {
                    result.add(num2);
                }
                pointer2++;
            }
        }

        while (pointer1 < n1){
            if (!result.contains(arr1[pointer1])) {
                result.add(arr1[pointer1]);
            }
            pointer1++;
        }

        while (pointer2 < n2){
            if (!result.contains(arr2[pointer2])) {
                result.add(arr2[pointer2]);
            }
            pointer2++;
        }

        int[] union = new int[result.size()];
        int index = 0;
        for (int element : result) {
            union[index++] = element;
        }

        return union;
    }


    // Brute Force Approach
    public static int[] findUnionV1(int[] arr1, int[] arr2) {
        Set<Integer> integerSet = new TreeSet<>();
        for (int element : arr1) {
            integerSet.add(element);
        }

        for (int element : arr2) {
            integerSet.add(element);
        }


        int[] result = new int[integerSet.size()];
        int i = 0;
        for (int element : integerSet) {
            result[i] = element;
            i++;
        }
        return result;
    }
}
