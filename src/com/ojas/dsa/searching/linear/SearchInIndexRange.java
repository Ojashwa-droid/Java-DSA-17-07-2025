package com.ojas.dsa.searching.linear;

public class SearchInIndexRange {
    public static void main(String[] args) {
        int[] number = {23, 34, 12, 343, -23, 1, 90, 34, 22, -78};
        int target = 23;
        int startIndex = 1;
        int endIndex = 6;

        int foundIndex = SearchInIndexRange.linearSerchInRange(number, startIndex, endIndex, target);
        System.out.println(foundIndex);
    }

    private static int linearSerchInRange(int[] number, int startIndex, int endIndex, int target) {

        if (number.length == 0)
            return -1;

        for (int i = startIndex; i <= endIndex; i++){
            if (number[i] == target)
                return i;
        }

        return -1;
    }
}
