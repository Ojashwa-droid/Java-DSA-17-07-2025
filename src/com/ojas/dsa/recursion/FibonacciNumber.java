package com.ojas.dsa.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
//        System.out.println(FibonacciNumber.fibo(5));

    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }


}