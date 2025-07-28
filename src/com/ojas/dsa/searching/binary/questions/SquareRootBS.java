package com.ojas.dsa.searching.binary.questions;

public class SquareRootBS {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));

        System.out.println(Math.sqrt(2147395599));

    }

    public static int mySqrt(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        long start = 1;
        long end = num;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            // if mid * mid is greater than the target number it means that we will not find our ans
            // after mid as the numbers are sorted
            // search in the left half
            if (mid * mid > num) {
                end = mid - 1;
            } else if (mid * mid < num) {
                // that means we are not going to find our ans in the left of mid
                // search in the right half
                start = mid + 1;
            } else {
                return (int) mid; // found the perfect square
            }


        }
        // if above return statement does not execute, it means the nuber doesnot have a perfect square
        // in that case return end
        // end will now be at the number which is nearest to the integer value of the square root of   our number
        return (int)end;
    }
}
