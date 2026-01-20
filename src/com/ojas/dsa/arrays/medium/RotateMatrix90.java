package com.ojas.dsa.arrays.medium;

public class RotateMatrix90 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] rotatedMatrix = rotateMatrixV1(matrix);
        int[][] rotatedMatrixOpt = rotateMatrixV2(matrix);

        System.out.println("Rotated Matrix: ");
        for (int i = 0; i < rotatedMatrixOpt.length; i++) {
            for (int j = 0; j < rotatedMatrixOpt[i].length; j++) {
                System.out.printf("%s", rotatedMatrixOpt[i][j] + "\t");
            }
            System.out.println();
        }

    }

    // Optimal Approach
    // In-place algorithm
    public static int[][] rotateMatrixV2(int[][] matrix){
        int n = matrix.length;

        // Reverse the original matrix column wise
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n / 2){
                swap(matrix, i, j, n - i - 1, j);
                i++;
            }
        }

        // Now, Transpose the current reversed matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j){
                    swap(matrix, i, j, j, i);
                }
            }
        }
        return matrix;
    }

    public static void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    // Brute Force -> Uses extra space O(n * n)
    public static int[][] rotateMatrixV1(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];


        for (int i = 0; i < n; i++) {
            int col = n - i - 1;
            int row = 0;
            for (int j = 0; j < n; j++) {
                ans[row][col] = matrix[i][j];
                row++;
            }
        }
        return ans;
    }
}
