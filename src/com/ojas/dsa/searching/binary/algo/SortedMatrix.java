package com.ojas.dsa.searching.binary.algo;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(Arrays.toString(binarySearchInSortedMatrix(matrix, 10)));

    }

    public static int[] binarySearchInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 1) { // If it's just a 1D matrix
            return binarySearchInRow(matrix, 0, target, 0, columns - 1);
        }


        // Take the lower bound as first row and upper bound as last row --> Find the middle row and apply binary search on it
        // you can do it with columns as well
        int rStart = 0;
        int rEnd = rows - 1;
        int midColumn = columns / 2;

        while (rStart < (rEnd - 1)) { // Until two rows are remaining this while loop will run
            // Find the middle row
            int midRow = rStart + (rEnd - rStart) / 2;

            /*// Apply binary search in the middle row elements as the elements are sorted
            if (matrix[midRow][0] >= target && matrix[midRow][matrix.length - 1] <= target) {
                // Element might exist in the row only
                // apply binary search on it
                return binarySearchInRow(matrix, midRow, target, 0, matrix.length - 1);
            }*/

            if (matrix[midRow][midColumn] == target) {
                return new int[]{midRow, midColumn};
            }

            if (matrix[midRow][midColumn] > target) {
                // Ignore the rows below it
                rEnd = midRow;
            } else if (matrix[midRow][midColumn] < target) {
                rStart = midRow;
            }
        }

        // Now we have two rows remaining
        // 1. Check whether the middle column elements of thw last two rows contain the ans or not
        if (matrix[rStart][midColumn] == target)
            return new int[]{rStart, midColumn};

        else if (matrix[rStart + 1][midColumn] == target)
            return new int[]{rEnd, midColumn};

        // Search in the 1st half
        if (target <= matrix[rStart][midColumn - 1]) {
            return binarySearchInRow(matrix, rStart, target, 0, midColumn - 1);
        }

        // Search in the 2nd half
        if (target >= matrix[rStart][midColumn + 1] && target <= matrix[rStart][columns - 1]) {
            return binarySearchInRow(matrix, rStart, target, midColumn + 1, columns - 1);
        }
        // Search in the 3rd half
        if (target <= matrix[rEnd][midColumn - 1]) {
            return binarySearchInRow(matrix, rEnd, target, 0, midColumn - 1);
        }
        // Search in the 4th half
        else {
            return binarySearchInRow(matrix, rEnd, target, midColumn + 1, columns - 1);
        }
    }

    public static int[] binarySearchInRow(int[][] matrix, int row, int target, int startCol, int endCol) {
        while (startCol <= endCol) {
            int mid = startCol + (endCol - startCol) / 2;

            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] > target) {
                endCol = mid - 1;
            } else {
                startCol = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
