package com.ojas.dsa.searching.binary.questions;

public class FloorOfANumber {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int result = FloorOfANumber.floorOfNumber(array, target);
        System.out.println("Floor: " + result);

    }

    // Return the element which is smaller than or equal to the target element
    // arr = [22, 31, 45, 60, 78] & target = 48
    //  --> ans = 45 is the largest element smaller than target
    private static int floorOfNumber(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        // What if the target element is smaller than the first element of the array
        if (target < array[start])
            return -1;

        // Given array is sorted in ascending order
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > array[mid]) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                return array[mid];
            }
        }

        // Reasoning: If the target element was present then it would have been returned in the while loop
        // but since it's not present, we have to return the element just greater than the target element
        // now, when the loop condition fails -> start is at the ceiling of that number cause the target element
        // is supposed be in between the start and end index, and end is the floor of the number.
        // And if the element is not present in the array that means at the end of the iteration, start will be at the ceiling
        // and end at the floor of that number.
        return array[end];
    }
}
