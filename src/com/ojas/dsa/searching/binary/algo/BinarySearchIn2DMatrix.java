package com.ojas.dsa.searching.binary.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {23, 34, 38, 50}
        };
        int target = -35;
        int[] result = BinarySearchIn2DMatrix.binarySearchInMatrix(matrix, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] binarySearchInMatrix(int[][] matrix, int target) {

        // Lower bound will be the first row i.e. row 0 and upper bound will be the last column i.e. matrix.length - 1
        int lower = 0;
        int upper = matrix[0].length - 1;

        while (lower <= upper) {

            // First condition if element == target --> ans found
            if (matrix[lower][upper] == target) {
                return new int[]{lower, upper};
            }

            // Second condition, if element < target
            // That means that in that particular row the elements before that element will also be smaller than the target
            // as the row is sorted (given) so we can ignore that row and reduce our search  space
            else if (matrix[lower][upper] < target) {
                lower++;
            }

            // Third condition, if the element > target
            // then the rest of the element in that column will be > than the target as the column is sorted
            // so ignore that column as well
            else if (matrix[lower][upper] > target) {
                upper--;
            }
        }

        // if the element is not found just return {-1,-1}
        return new int[]{-1, -1};
    }
}
