package com.ojas.dsa.searching.binary.questions;

class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(findKthPositive(array, 3));
    }


    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missingNumbers = arr[mid] - (mid + 1);

            if (missingNumbers < k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end + k;
    }
}