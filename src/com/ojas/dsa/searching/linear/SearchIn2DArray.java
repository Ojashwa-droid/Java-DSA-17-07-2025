package com.ojas.dsa.searching.linear;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
/*        int[][] array = new int[][]{
                {1, 11, 4, 67},
                {2, 56, 67},
                {90, -8, 560}
        };
*/

        int[][] array = {
                {1, 11, 4, 67},
                {2, 56, 67},
                {90, -8, 560}
        };

        int target = -90;

        int[] search = linearSearchIn2DArray(array, target); // Format of return value : {rowIndex, colIndex}
        System.out.println(Arrays.toString(search));

        System.out.println("Min element: " + minIn2DArray(array) + ", Max element: " + maxIn2DArray(array));

    }

    private static int[] linearSearchIn2DArray(int[][] array, int target) {
        // An integer array to hold the row index and column index
        // index-0 : row-index
        // index-1 : column-index
        int[] indices = {-1, -1};

        if (array.length == 0)
            return indices;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    private static int maxIn2DArray(int[][] array) {

        if (array.length == 0)
            return Integer.MAX_VALUE;

        int max = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        return max;
    }

    private static int minIn2DArray(int[][] array) {

        if (array.length == 0)
            return Integer.MIN_VALUE;

        int min = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }

        return min;
    }
}
