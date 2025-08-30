package com.ojas.dsa.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
//        System.out.println(FibonacciNumber.fibo(5));
        int[] array = new int[]{-10, 2, 3, 13, 24, 52};
        System.out.println(binarySearch(array, 2, 0, array.length - 1));
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (array[mid] == target){
            return mid;
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, end);
        } else {
            return binarySearch(array, target, start, mid - 1);
        }
    }
}