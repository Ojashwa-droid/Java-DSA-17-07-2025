package com.ojas.dsa.pattern;

public class Pattern {
    public static void main(String[] args) {
//        pattern1(4);
//        pattern2(4);
//        pattern3(5);
//        pattern4(5);
//        pattern5(5);
//        pattern6(5);
//        pattern28(5);
        pattern30(5);
        pattern67(5);
    }

    public static void pattern34(int n) {
        for (int row = 1; row < 2 * n; row++) {

        }



    }

    public static void pattern67(int n) {
        /*

                1
              2 1 2
            3 2 1 2 3
          4 3 2 1 2 3 4
        5 4 3 2 1 2 3 4 5
          4 3 2 1 2 3 4
            3 2 1 2 3
              2 1 2
                1

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row < 2 * n; row++) {
            // For every row, run the col
            int c = (row > n) ? n - (row - n) : row;

            for (int space = 1; space <= n - c; space++) {
                System.out.print("  ");
            }

            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }

            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern30(int n) {
        /*

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= n; row++) {
            // For every row, run the col
            int totalColumnInRow = (2 * row) - 1;
            int spaces = n - row;

            for (int space = 1; space <= spaces; space++) {
                System.out.print("  ");

            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            // another way to do this
//            for (int col1 = 1; col1 <= (totalColumnInRow / 2) + 1 ; col1++) {
//                System.out.print(row - col1 + 1);
//            }
//
//            for (int col2 = 1; col2 <= totalColumnInRow / 2; col2++) {
//                System.out.print(2 + col2 - 1);
//            }

            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }


    public static void pattern28(int n) {
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         * * * *
         * * *
         * *
         *
         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= (2 * n) - 1; row++) {
            // For every row, run the col
            int totalColumnInRow = (row > n) ? n - (row - n) : row;
            int spaces = (row <= n) ? n - row : row - n;

            for (int space = 1; space <= spaces; space++) {
                System.out.print(" ");

            }

            for (int col = 1; col <= totalColumnInRow; col++) {
                System.out.print("* ");

            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }


    public static void pattern1(int n) {
        /*
         * * * *
         * * * *
         * * * *
         * * * *
         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= n; row++) {
            // For every row, run the col
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern2(int n) {
        /*
         *
         * *
         * * *
         * * * *
         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= n; row++) {
            // For every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern3(int n) {
        /*
         * * * * *
         * * * *
         * * *
         * *
         *

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= n; row++) {
            // For every row, run the col
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");

            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern4(int n) {
        /*
         * * * * *
         * * * *
         * * *
         * *
         *

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= n; row++) {
            // For every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");

            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern5(int n) {
        /*
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        1 2 3 4
        1 2 3
        1 2
        1

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= (2 * n) - 1; row++) {
            // For every row, run the col
            int totalColumnInRow = (row > n) ? n - (row - n) : row;
            for (int col = 1; col <= totalColumnInRow; col++) {
                System.out.print(col + " ");

            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }

    public static void pattern6(int n) {
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         * * * *
         * * *
         * *
         *

         */

        // Run the outer for loop as many times as we have the number of rows
        for (int row = 1; row <= (2 * n) - 1; row++) {
            // For every row, run the col
            int totalColumnInRow = (row > n) ? n - (row - n) : row;
            for (int col = 1; col <= totalColumnInRow; col++) {
                System.out.print("* ");

            }
            // When one row is printed, we need a new line
            System.out.println();
        }
        System.out.println();
    }


}
