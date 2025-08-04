package com.ojas.dsa.searching.binary.questions;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
public class CountNegInSortedMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(countNegative(matrix));
    }

    public static int countNegative(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1; // So our current element will be at indices {row, column}
        int count = 0;

        while (row <= rows && column >= 0) {
            if (matrix[row][column] < 0) {
                // Elements below current element will always be < 0 as its col-wise and row-wise sorted matrix.
                // Add the number of rows to count and skip the column
                count += rows - row;
                column--;
            } else {
                row++;
            }
        }
        return count;
    }
}
