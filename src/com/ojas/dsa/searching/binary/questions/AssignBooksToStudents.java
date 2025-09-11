package com.ojas.dsa.searching.binary.questions;

public class AssignBooksToStudents {
    public static void main(String[] args) {
        int[] array = {25, 46, 28, 49, 24};
        int students = 4;
        System.out.println(assignBooks(array, students));
    }

    public static int assignBooks(int[] array, int m) {
        if (array.length < m) {
            return -1;
        }

        int start = Integer.MIN_VALUE;
        for (int pages : array) {
            if (pages > start) {
                start = pages;
            }
        }

        int end = 0;
        for (int pages : array) {
            end += pages;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int countStudent = fun(array, mid);
            if (countStudent > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int fun(int[] array, int pages) {
        int students = 1;
        int allocation = 0;
        for (int i = 0; i < array.length; i++) {
            if (allocation + array[i] <= pages) {
                allocation += array[i];
            } else {
                students++;
                allocation = array[i];
            }
        }
        return students;
    }

}
