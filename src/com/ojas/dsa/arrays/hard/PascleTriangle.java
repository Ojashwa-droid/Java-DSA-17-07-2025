package com.ojas.dsa.arrays.hard;

import java.util.*;

public class PascleTriangle {
    public static void main(String[] args) {
        System.out.println(pascleTriangleTypeOne(5, 3));
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> integerSet = hashMap.keySet();
    }

    public static long pascleTriangleTypeOne(int row, int col){
        // row -> n, col -> r
        int n = row - 1, r = col - 1;
        return findElementNcR(n, r);
    }

    private static long findElementNcR(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }
}
