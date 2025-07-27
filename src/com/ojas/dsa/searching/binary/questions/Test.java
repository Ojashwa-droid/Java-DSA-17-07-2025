package com.ojas.dsa.searching.binary.questions;

public class Test {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 0, 1, 2};


        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]){
                // you are in
            }
        }
    }
}
