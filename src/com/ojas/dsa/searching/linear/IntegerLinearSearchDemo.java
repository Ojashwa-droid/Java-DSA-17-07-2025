package com.ojas.dsa.searching.linear;

public class IntegerLinearSearchDemo {
    public static void main(String[] args) {

        int[] number = {23, 34, 12, 343, -23, 1, 90, 34, 22, -78};
        int target = 0;
        int foundIndex = IntegerLinearSearchDemo.linearSearch(number, target);
        System.out.println("Index: " + foundIndex);

    }

    // Search in the array: return the index if the item found
    // otherwise return -1
    public static int linearSearch(int[] array, int target) {
        if (array.length == 0)
            return -1;

        for (int index = 0; index < array.length; index++) {
            // for every index check if the element is equal to the target element
            if (array[index] == target)
                return index;
        }

        // This statement will execute in case none of the return statements get executed
        // --> meaning the item was not found in the array, hence return -1.
        return -1;
    }
}
