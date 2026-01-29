package com.ojas.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 9},
                {9, 11},
                {8, 10},
                {2, 4},
                {15, 18},
                {16, 17}
        };
        int[][] mergedIntervals = mergeV2(intervals);
        for (int[] row : mergedIntervals) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] mergeV2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(row -> row[0])
                .thenComparingInt(row -> row[1]));

        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;

        // Insert the first sub-interval as the first non-overlapping interval in the result
        result.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        int i = 1;
        while (i < n) {
            if (intervals[i][0] > result.getLast().get(1)) {
                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                int start = result.getLast().get(0);
                int end = result.getLast().get(1);
                end = Math.max(end, intervals[i][1]);
                result.removeLast();
                result.addLast(Arrays.asList(start, end));
            }
            i++;
        }


//        for (int i = 0; i < n; i++) {
//            if (result.isEmpty() || intervals[i][0] > result.getLast().get(1)){
//                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
//            }
//            else {
//                int start = result.getLast().get(0);
//                int end = Math.max(intervals[i][1], result.getLast().get(1));
//                result.removeLast();
//                result.addLast(Arrays.asList(start, end));
//            }
//        }

        int[][] answer = new int[result.size()][2];
        int index = 0;
        for (List<Integer> list : result) {
            answer[index][0] = list.get(0);
            answer[index][1] = list.get(1);
            index++;
        }
        return answer;

    }

    public static int[][] merge(int[][] intervals) {
        // First sort the array based on the first index of each row,
        // such that the sub-intervals become closer to each other

        Arrays.sort(intervals, Comparator.<int[]>comparingInt(row -> row[0])
                .thenComparingInt(row -> row[1]));

        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // First check the current sub-interval to be an overlapping one or not
            // meaning is there a sub-interval in the result List that can overlap the current sub-interval

            if (!result.isEmpty() && end <= result.getLast().get(1)) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            List<Integer> tempList = Arrays.asList(start, end);
            result.add(tempList);
        }

        int[][] answer = new int[result.size()][2];
        int index = 0;
        for (List<Integer> list : result) {
            answer[index][0] = list.get(0);
            answer[index][1] = list.get(1);
            index++;
        }
        return answer;
    }
}
