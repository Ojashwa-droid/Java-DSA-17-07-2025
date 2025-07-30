package com.ojas.dsa.searching.binary.algo;

import java.util.Arrays;

public class SortedMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(Arrays.toString(search(matrix, 10)));
    }

    public static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 1) { // If it's just a 1D matrix
            return binarySearchInRow(matrix, 0, target, 0, columns - 1);
        }

        int rStart = 0;
        int rEnd = rows - 1;

        while (rStart <= rEnd) {
            int midRow = rStart + (rEnd - rEnd) / 2;

            // If the row you are on has the target element
            if (matrix[midRow][0] <= target && matrix[midRow][columns - 1] >= target) {
                // Element only possible in this row
                // apply binary search on this row
                return binarySearchInRow(matrix, midRow, target, 0, columns - 1);
            }

            // 2nd condition to reduce our search space
            if (matrix[midRow][columns - 1] < target) {
                // We can certainly ignore the rows above it and midRow as well
                // cause if the element was in the midRow it would have been caught
                rStart = midRow + 1;
            } else if (matrix[midRow][0] > target) {
                // Ignore the rows below it and the midRow itself
                rEnd = midRow - 1;
            }
        }

        return new int[]{-1, -1};

    }


    public static int[] binarySearchInRow(int[][] matrix, int row, int target, int startCol, int endCol) {

        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;

            if (matrix[row][midCol] == target){
                return new int[]{row, midCol};
            } else if (matrix[row][midCol] > target){
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
