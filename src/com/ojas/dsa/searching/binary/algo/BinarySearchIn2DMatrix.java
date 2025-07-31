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
        int target = 37;
        int[] result = BinarySearchIn2DMatrix.binarySearchInMatrix(matrix, target);
        System.out.println(Arrays.toString(result));

    }

    /**
     * public static int[] binarySearchInMatrix(int[][] matrix, int target) {
     * <p>
     * // Lower bound will be the first row i.e. row 0 and upper bound will be the last column i.e. matrix.length - 1
     * int lower = 0;
     * int upper = matrix[0].length - 1;
     * <p>
     * while (lower <= upper) {
     * <p>
     * // First condition if element == target --> ans found
     * if (matrix[lower][upper] == target) {
     * return new int[]{lower, upper};
     * }
     * <p>
     * // Second condition, if element < target
     * // That means that in that particular row the elements before that element will also be smaller than the target
     * // as the row is sorted (given) so we can ignore that row and reduce our search  space
     * else if (matrix[lower][upper] < target) {
     * lower++;
     * }
     * <p>
     * // Third condition, if the element > target
     * // then the rest of the element in that column will be > than the target as the column is sorted
     * // so ignore that column as well
     * else if (matrix[lower][upper] > target) {
     * upper--;
     * }
     * }
     * <p>
     * // if the element is not found just return {-1,-1}
     * return new int[]{-1, -1};
     * }
     */

    public static int[] binarySearchInMatrix(int[][] matrix, int target) {
        int lower = 0;
        int upper = matrix[0].length - 1;

        // So our current element will be at indices [lower][upper]
        // We then compare the current element with our target element
        while (lower <= upper){
            if (matrix[lower][upper] == target) {
                // we found our answer
                return new int[]{lower, upper};
            } else if (matrix[lower][upper] > target) {
                // meaning that column can not have our target element
                // so skip that column entirely
                upper--;
            } else if (matrix[lower][upper] < target) {
                // That row can not have our element
                // skip that row entirely
                lower++;
            }
        }

        // In the end if the target is not found
        return new int[]{-1, -1};
    }
}
