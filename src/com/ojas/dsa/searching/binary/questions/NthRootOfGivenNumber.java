package com.ojas.dsa.searching.binary.questions;

public class NthRootOfGivenNumber {
    public static void main(String[] args) {
        System.out.println(nthRoot(16, 2));
    }

    public static int nthRoot(int number, int n) {
        if (number <= 0) {
            return -1;
        }
        int start = 1;
        int end = number;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // condition for the mid to be our ans
            if (power(mid, n, number) == 1) {
                return mid;
            } else if (power(mid, n, number) == 2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Return 1 if == number
    // Return 2 if > number
    // Return 0 if < number
    public static int power(int base, int exp, int number){
        long result = 1;
        for (int i = 1; i <= exp; i++) {
            result = result * base;
            if (result > number){
                return 2;
            }
        }
        if (result == number){
            return 1;
        } else {
            return 0;
        }
    }
}
