package com.ojas.dsa.recursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] array = new int[]{-10, 2, 3, 13, 24, 52};
        System.out.println(binarySearch(array, 240, 0, array.length - 1));
    }
    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end){
            return -1;
        }

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