package com.ojas.dsa.searching.linear;

public class FindMinMaxInArray {
    public static void main(String[] args) {
        int[] number = {23, 34, 12, 343, -23, 1, 90, 34, 22, -78};

        int minElement = FindMinMaxInArray.minElement(number);
        int maxElement = FindMinMaxInArray.maxElement(number);

        System.out.println("Min Eelement: " + minElement + ", Max Element: " + maxElement);
    }

    private static int minElement(int[] number) {
        int min = number[0];

        for (int i = 1; i < number.length; i++) {
            if (number[i] < min)
                min = number[i];
        }

        // After iterating through the entire array we'll have our minimum element
        return min;
    }

    private static int maxElement(int[] number) {
        int max = number[0];

        for (int i = 1; i < number.length; i++) {
            if (number[i] > max)
                max = number[i];
        }

        return max;
    }
}
